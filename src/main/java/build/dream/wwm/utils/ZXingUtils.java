package build.dream.wwm.utils;

import build.dream.wwm.constants.Constants;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class ZXingUtils {
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;
    public static final String FORMAT_NAME_PNG = "png";

    /**
     * 生成二维码
     *
     * @param width
     * @param height
     * @param data
     * @param outputStream
     */
    public static void generateQRCode(int width, int height, String data, OutputStream outputStream) {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            ImageIO.write(bufferedImage, FORMAT_NAME_PNG, outputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成条码
     *
     * @param width
     * @param height
     * @param data
     * @param outputStream
     */
    public static void generateBarCode(int width, int height, String data, OutputStream outputStream) {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128, width, height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            ImageIO.write(bufferedImage, FORMAT_NAME_PNG, outputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析二维码
     *
     * @param inputStream
     * @return
     */
    private static String parse(InputStream inputStream) {
        try {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
            Binarizer binarizer = new HybridBinarizer(luminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            HashMap<DecodeHintType, Object> decodeHints = new HashMap<DecodeHintType, Object>();
            decodeHints.put(DecodeHintType.CHARACTER_SET, Constants.CHARSET_NAME_UTF_8);
            Result result = new MultiFormatReader().decode(binaryBitmap, decodeHints);
            return result.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析二维码
     *
     * @param inputStream
     * @return
     */
    public static String parseQRCode(InputStream inputStream) {
        return parse(inputStream);
    }

    /**
     * 解析二维码
     *
     * @param file
     * @return
     */
    public static String parseQRCode(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parseQRCode(inputStream);
    }

    /**
     * 解析条码
     *
     * @param inputStream
     * @return
     */
    public static String parseBarCode(InputStream inputStream) {
        return parse(inputStream);
    }

    /**
     * 解析条码
     *
     * @param file
     * @return
     */
    public static String parseBarCode(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parseQRCode(inputStream);
    }
}

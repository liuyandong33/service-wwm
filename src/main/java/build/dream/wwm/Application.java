package build.dream.wwm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan
@MapperScan(basePackages = {"build.dream.wwm.mappers"})
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        int[] array = new int[]{-1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(first(array));
//        System.out.println(second(array));
    }

    public static long first(int[] array) {
        int length = array.length;
        int maxSum = array[0];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += array[k];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static long second(int[] array) {
        int length = array.length;
        int maxSum = array[0];
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += array[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}

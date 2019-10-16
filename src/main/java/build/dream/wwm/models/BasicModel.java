package build.dream.wwm.models;

import build.dream.wwm.utils.ValidateUtils;

public class BasicModel {
    public boolean validate() {
        return ValidateUtils.validate(this);
    }

    public void validateAndThrow() {
        ValidateUtils.validateAndThrow(this);
    }
}

package com.sequoia.web.fileupload;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sunjun on 16/9/28.
 */
@Component
public class MultipartFileBucketValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return MultipartFileBucket.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        MultipartFileBucket multipartFileBucket = (MultipartFileBucket) obj;
        if (multipartFileBucket.getMultipartFile() != null) {
            if (multipartFileBucket.getMultipartFile().getSize() == 0) {
                errors.rejectValue("multipartFile",
                        "MultipartFileBucketValidator.multipartFileBucket.multipartFile",
                        "请选择需上传的文件");
            }
        }
    }
}
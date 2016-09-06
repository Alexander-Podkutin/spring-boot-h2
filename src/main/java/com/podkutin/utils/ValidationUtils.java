package com.podkutin.utils;

import com.google.common.base.Preconditions;
import com.podkutin.exception.BadRequestException;

/**
 * Created by apodkutin on 9/6/2016.
 */
public class ValidationUtils {

    public static void validateParam(Object paramValue, String errorMessage) {
        try {
            Preconditions.checkNotNull(paramValue);
        } catch (NullPointerException ex) {
            throw new BadRequestException(errorMessage);
        }
    }
}

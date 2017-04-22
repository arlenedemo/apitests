package com.hsbc.digital.testautomation.test;

/**
 * Created by arlene.lehakra on 23/01/2017.
 */
public class ErrorInfo {

    public String code;
    ErrorDetail detail;

    @Override
    public boolean equals(final Object other){
        if(!(other instanceof ErrorInfo)){
            return false;
        }

        ErrorInfo that = (ErrorInfo) other;

        if(this.code.equalsIgnoreCase(that.code) && this.detail.equals(that.detail)) {
            return true;
        }
        else
        {
            return false;
        }
    }
}

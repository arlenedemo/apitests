package com.hsbc.digital.testautomation.test;

/**
 * Created by arlene.lehakra on 23/01/2017.
 */
public class ErrorDetail {

    public String field;
    public String message;

    @Override
    public boolean equals(final Object other){
        if(!(other instanceof ErrorDetail)){
            return false;
        }

        ErrorDetail that = (ErrorDetail) other;

        if(this.field.equalsIgnoreCase(that.field) && this.message.equalsIgnoreCase(that.message)){
            return true;
        } else{
            return false;
        }
    }
}

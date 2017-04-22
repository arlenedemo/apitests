package com.demo.digital.testautomation.test;

import com.google.gson.Gson;
import com.demo.digital.testautomation.config.ConfigProvider;
import com.demo.digital.testautomation.restassured.RestAssuredCore;
import com.jayway.restassured.response.ExtractableResponse;
import com.typesafe.config.Config;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class RequestValidation {

    private Config config;

    private ExtractableResponse response;

    @Before
    public void setUp() throws Exception{
        this.config= ConfigProvider.config();
        //RestAssured.baseURI= this.config.getString("BaseApiUri");
    }


    private static Request getFullRequest(){
        Request allDataPresent = new Request();
        DocumentProperties documentData = new DocumentProperties();
        documentData.documentFormat="pdf";
        documentData.fileName="test.pdf";
        documentData.countryCode="UK";
        documentData.grpMbrCode="HBEU";
        documentData.folderId="1234567890";
        documentData.folderType="000020";
        allDataPresent.documentData = documentData;
        return allDataPresent;
    }

    private static ValidationResponse getFullResponse(){
        ValidationResponse response = new ValidationResponse();
        response.requestCorrelation="";
        response.sessionCorrelation="";

        ErrorInfo info= new ErrorInfo();
        info.code="DU_VAL_FM_01";

        ErrorDetail detail= new ErrorDetail();
        detail.field="/documentData";
        detail.message="Field is missing";

        info.detail= detail;

        response.errorInfo = new ErrorInfo[] {info};

        return response;
    }


    public void fileNameMissing(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.fileName=null;

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse((this.config.getString("iccmBaseApiUri")),jsonBody,UploadDocumentType.PDF_SMALL, HttpStatus.SC_BAD_REQUEST);

        ValidationResponse serviceResp = gson.fromJson(response.asString(), ValidationResponse.class);

        ErrorInfo[] errors = new ErrorInfo[1];
        ErrorInfo err = new ErrorInfo();
        err.code = "DU_VAL_MF_04";
        err.detail = new ErrorDetail();
        err.detail.field= "/documentData/fileName";
        err.detail.message= "Field is missing!";

        errors[0]= err;

        Boolean[] errorPresent = new Boolean[1];

        for (int i=0; i<serviceResp.errorInfo.length; i++){
            for(int j=0; j<errors.length ; j++){
                if(serviceResp.errorInfo[i].equals(errors[j])){
                    errorPresent[j]= true;
                }
            }
        }

        boolean finalTrue = true;
        for(int j=0; j<errorPresent.length; j++){
            finalTrue = finalTrue && errorPresent[j];
        }

        assertTrue(finalTrue);
    }

    public void countryCodeMissing(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.countryCode=null;

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response=RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action3",jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_BAD_REQUEST);

        RestAssuredCore.printResponse(response);

        ValidationResponse serviceResp = gson.fromJson(response.asString(), ValidationResponse.class);

        ErrorInfo[] errors = new ErrorInfo[1];
        ErrorInfo err = new ErrorInfo();
        err.code = "DU_VAL_MF_03";
        err.detail = new ErrorDetail();
        err.detail.field= "/documentData/countryCode";
        err.detail.message= "Field is missing!";

        errors[0]= err;

        Boolean[] errorPresent = new Boolean[1];

        for (int i=0; i<serviceResp.errorInfo.length; i++){
            for(int j=0; j<errors.length ; j++){
                if(serviceResp.errorInfo[i].equals(errors[j])){
                    errorPresent[j]= true;
                }
            }
        }

        boolean finalTrue = true;
        for(int j=0; j<errorPresent.length; j++){
            finalTrue = finalTrue && errorPresent[j];
        }

        assertTrue(finalTrue);
    }

    public void verifyResponseCode(int expectedCode){
        int expected = 400;
        int actual = response.statusCode();
        
        Assert.assertEquals(expected, actual);
    }


    public void folderIdLessThan10Char(){
        Request allDataPresent = getFullRequest();
        allDataPresent.documentData.folderId="123456";

        Gson gson= new Gson();
        String jsonBody = gson.toJson(allDataPresent);
        System.out.println(jsonBody);


        response = RestAssuredCore.postAsMultipartAndReturnResponse("http://localhost:8081/tutorial1/action3",jsonBody,UploadDocumentType.JPEG_SMALL, HttpStatus.SC_BAD_REQUEST);
    }

}

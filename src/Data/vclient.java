/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author rolae
 */
public class vclient extends vperson{
    private String code_client;

    public vclient() {
    }

    public vclient(String code_client) {
        this.code_client = code_client;
    }

    public String getCode_client() {
        return code_client;
    }

    public void setCode_client(String code_client) {
        this.code_client = code_client;
    }

    
    
}

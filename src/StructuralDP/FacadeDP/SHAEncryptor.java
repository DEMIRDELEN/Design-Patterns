package StructuralDP.FacadeDP;

public class SHAEncryptor {
    public void encrypt(String text, String key, boolean type) {
        if (type) {
            System.out.println("<MD5>" + text + key + "</MD5>");
        } else {
            System.out.println("<MD5>" + key + text + "</MD5>");
        }
    }
}

package code.utility.coding;

import java.util.Base64;

public class Base64Utility {
    // Constructor para evitar la instanciación
    private Base64Utility() {}

    // Convertir de Bytes a Base64
    public static String bytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    // Convertir de Base64 a Bytes
    public static byte[] base64ToBytes(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}

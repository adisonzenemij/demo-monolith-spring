package code.utility.coding;

import java.io.ByteArrayOutputStream;

public class Utf8Utility {
    // Constructor para evitar la instanciación
    private Utf8Utility() {}

    // Convertir de Bytes a UTF-8 escapado
    public static String escapeUTF8(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            char c = (char) (b & 0xFF);
            if (Character.isISOControl(c) || c > 127) {
                sb.append(
                    String.format(
                        "\\u%04x",
                        (int) c
                    )
                );
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Convertir de UTF-8 escapado a Bytes
    public static byte[] unescapeUTF8(String escaped) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int length = escaped.length();
        int position = 0;

        while (position < length) {
            if (escaped.charAt(position) == '\\' &&
                position + 5 < length &&
                escaped.charAt(position + 1) == 'u'
            ) {
                String hex = escaped.substring(position + 2, position + 6);
                baos.write((char) Integer.parseInt(hex, 16));
                position += 6;
            } else {
                baos.write((byte) escaped.charAt(position));
                position += 1;
            }
        }

        return baos.toByteArray();
    }
}

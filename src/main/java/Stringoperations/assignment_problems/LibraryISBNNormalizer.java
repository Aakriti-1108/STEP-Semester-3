package Stringoperations.assignment_problems;

public class LibraryISBNNormalizer {

    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisher = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisher + remaining;
    }

    static String validateAndFormat(String code) {

        String normalized = normalizeCode(code);

        // Check length
        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < normalized.length(); i++) {

            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        String code = " pen2026004251 ";

        System.out.println(validateAndFormat(code));
    }
}

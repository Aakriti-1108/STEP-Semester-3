package string.class_problems;

public class BankTransactionRefernceGenerator {

    static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    static String validateAndFormat(String reference) {

        String normalized = normalizeReference(reference);

        // Check length
        if (normalized.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < normalized.length(); i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String date = normalized.substring(3, 9);
        String sequence = normalized.substring(9, 14);

        String formattedDate =
                date.substring(0, 2) + "/" +
                        date.substring(2, 4) + "/" +
                        date.substring(4, 6);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(formattedDate);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        String reference = " hdf03022600042 ";

        System.out.println(validateAndFormat(reference));
    }
}
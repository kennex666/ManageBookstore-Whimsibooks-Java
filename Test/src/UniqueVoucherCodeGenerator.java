import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueVoucherCodeGenerator {

    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxyz0123456789_";
    private static final int VOUCHER_CODE_LENGTH = 6;

    private static Set<String> generatedCodes = new HashSet<>();

    public static String generateUniqueVoucherCode() {
        Random random = new Random();
        StringBuilder voucherCode = new StringBuilder("Voucher_");

        for (int i = 0; i < VOUCHER_CODE_LENGTH; i++) {
            char randomChar = ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length()));
            voucherCode.append(randomChar);
        }

        // Kiểm tra xem mã voucher đã tồn tại chưa
        while (generatedCodes.contains(voucherCode.toString())) {
            voucherCode = new StringBuilder("Voucher_");
            for (int i = 0; i < VOUCHER_CODE_LENGTH; i++) {
                char randomChar = ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length()));
                voucherCode.append(randomChar);
            }
        }

        // Thêm mã voucher mới vào danh sách
        generatedCodes.add(voucherCode.toString());

        return voucherCode.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String voucherCode = generateUniqueVoucherCode();
            System.out.println("Generated Voucher Code: " + voucherCode);
        }
    }
}
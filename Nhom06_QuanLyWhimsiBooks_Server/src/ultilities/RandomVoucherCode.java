package ultilities;

import java.util.Random;
import java.util.Set;

public class RandomVoucherCode {
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxyz0123456789_";
    private static final int VOUCHER_CODE_LENGTH = 6;
    
//    private static Set<String> generatedCodes = new HashSet<>();
    
    public static String VoucherCode(String nameRequired, Set<String> generatedCodes) {
        Random random = new Random();
        StringBuilder voucherCode = new StringBuilder(nameRequired);

        for (int i = 0; i < VOUCHER_CODE_LENGTH; i++) {
            char randomChar = ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length()));
            voucherCode.append(randomChar);
        }

        // Kiểm tra xem mã voucher đã tồn tại chưa
        while (generatedCodes.contains(voucherCode.toString())) {
            voucherCode = new StringBuilder(nameRequired);
            for (int i = 0; i < VOUCHER_CODE_LENGTH; i++) {
                char randomChar = ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length()));
                voucherCode.append(randomChar);
            }
        }
        
        return voucherCode.toString();
    }
}

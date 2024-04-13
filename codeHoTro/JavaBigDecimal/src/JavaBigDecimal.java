
import java.math.BigDecimal;


public class JavaBigDecimal {

    /**
     * @by haiyenng
     */
    public static void main(String[] args) {
        
        // test Double and Float
        float f1 = 0.1f;
        float f2 = 0.2f;
        float f3 = f1 * f2;
        System.out.println(f3);  // KQ : true khi + , và false khi *
        
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 * d2;
        System.out.println(d3); // KQ : false khi + vaf * 
        
        // Thay vì dùng float và double để tính tiền , nó sẽ xảy ra sai đố 
        // Ta sử dụng BIGDECIMAL : phải ép kiểu và khi thực hiện phép tính phải dùng code
        // Test
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        BigDecimal bd2 = BigDecimal.valueOf(0.2);
        BigDecimal bd3 = bd1.add(bd2);
        System.out.println(bd3); // TRUE
        BigDecimal bd4 = bd1.multiply(bd2); 
        System.out.println(bd4);
    }

}

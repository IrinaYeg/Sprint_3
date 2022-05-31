import com.github.javafaker.Faker;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

public class Order extends RestAssuredClient {

    public String firstName;
    public String lastName;
    public String address;
    public String metroStation;
    public String phone;
    public int rentTime;
    public String deliveryDate;
    public String comment;
    public List<String> color;
    public static Instant time = Instant.now();

    public static Faker faker = new Faker(new Locale("ru"));



    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;;
    }

    public static Order createOrder(List<String> colorKind) {
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String address = faker.address().streetAddress();
        final String metroStation = faker.address().streetName();
        final String phone = faker.phoneNumber().phoneNumber();
        final int rentTime = faker.number().numberBetween(0, 15);
        final String deliveryDate = faker.date().toString();
        final String comment = faker.rickAndMorty().quote();
        final List<String> color = colorKind;
        return new Order(firstName, lastName, address, metroStation, phone, rentTime,
                deliveryDate, comment, color);


       /* Map<String, Object> data = new HashMap<>();
        data.put( "firstName", "Naruto" );
        data.put( "lastName", "Uchiha" );
        data.put( "address", "Konoha, 142 apt." );
        data.put( "metroStation", 4 );
        data.put( "phone", "+7 800 355 35 35" );
        data.put( "rentTime", 5 );
        data.put( "deliveryDate", "2021-06-10" );
        data.put( "comment", "Uchiha" );
        data.put( "color", color);
        String json = new ObjectMapper().writeValueAsString(data);
        */

    }
}
package _03;

public class EnumsExample {

  public static void main(String[] args) {
    System.out.println(ResponseCode.SUCCESS.getClass());
    System.out.println(ResponseCode.SUCCESS.getCode());

    ResponseCode responseCode = ResponseCode.valueOf(1);
    System.out.println(responseCode);

//    {
//    Scanner in = new Scanner(System.in);
//    String input = in.nextLine();
//
//    Season season1 = Enum.valueOf(Season.class, "WINTER");
//    Season season = Season.valueOf(input.toUpperCase());
//
//    if (season == Season.WINTER){
//      System.out.println("This is winter");
//    }
//    if (season.equals(Season.WINTER)){
//      System.out.println("This is winter");
//    }
//
//    switch (season) {
//      case WINTER:
//        break;
//      case SPRING:
//        break;
//      case SUMMER:
//        break;
//      case AUTUMN:
//        break;
//    }}


  }


  interface Successable {

    boolean isOK();
  }


  public enum ResponseCode implements Successable{
    SUCCESS(0){
      @Override
      public String toString() {
        return "HELLO FROM SUCCCESS" + super.toString();
      }

      @Override
      public boolean isOK() {
        return true;
      }
    },
    FAILED(1){
      @Override
      public boolean isOK() {
        return false;
      }
    },
    EXPIRED(2){
      @Override
      public boolean isOK() {
        return false;
      }
    },
    PARTIALLY_SUCCESS(3){
      @Override
      public boolean isOK() {
        return true;
      }
    };

    private static final int STATIC = 100;
    private final int code;

    static {

    }

    ResponseCode(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    @Override
    public String toString() {
      return "ResponseCode{" +
          "name=" + name() +
          ", code=" + code +
          '}';
    }



    public static ResponseCode valueOf(int code){
      for (ResponseCode responseCode: values()) {
        if(responseCode.code == code){
          return responseCode;
        }
      }
      return null;
    }

//    @Override
//    public boolean isOK() {
//      switch (this){
//        case SUCCESS:
//        case PARTIALLY_SUCCESS:
//          return true;
//
//        default:
//          return false;
//      }
//    }
  }
}



enum Season {
  UNKNOWN,
  SPRING,
  WINTER,
  SUMMER,
  AUTUMN
}

#include <SoftwareSerial.h>//incluimos SoftwareSerial
#include <TinyGPS.h>//incluimos TinyGPS

const int RX = 11;
const int TX = 12;

TinyGPS gps;//Declaramos el objeto gps
SoftwareSerial serialgps(TX,RX);//Declaramos el pin 4 Tx y 3 Rx

//Declaramos la variables para la obtención de datos
int year;
byte month, day, hour, minute, second, hundredths;
unsigned long chars;
unsigned short sentences, failed_checksum;

void setup()
{
  Serial.begin(115200);//Iniciamos el puerto serie
  serialgps.begin(9600);//Iniciamos el puerto serie del gps
  //Imprimimos:
  Serial.println("");
  Serial.println("GPS GY-GPS6MV2 Leantec");
  Serial.println(" ---Buscando senal--- ");
  Serial.println("");
}

void loop()
{
  while(serialgps.available()) 
  {
    int c = serialgps.read();
 
    if(gps.encode(c))  
    {
      float latitude, longitude;
      gps.f_get_position(&latitude, &longitude);
      Serial.print("Latitud: "); 
      Serial.print(latitude,5); 
      Serial.print(", "); 
      Serial.print("Longitud: "); 
      Serial.println(longitude,5);
    }
  }
}

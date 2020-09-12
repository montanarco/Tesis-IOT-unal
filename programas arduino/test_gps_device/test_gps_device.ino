#include <SoftwareSerial.h>//incluimos SoftwareSerial
#include <TinyGPS.h>//incluimos TinyGPS

// defines pins numbers
const int trigPin = 6;
const int echoPin = 7;
const int RX = 3;
const int TX = 4;

// defines variables
long duration;
int distance;

// defines library elements
TinyGPS gps;//Declaramos el objeto gps
SoftwareSerial serialgps(TX,RX);//Declaramos el pin 4 Tx y 3 Rx

//Declaramos la variables para la obtención de datos
int year;
byte month, day, hour, minute, second, hundredths;
unsigned long chars;
unsigned short sentences, failed_checksum;

void setup()
{ 
  pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
  pinMode(echoPin, INPUT); // Sets the echoPin as an Input
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

      // measuring the distance with HC-SR04
      // Clears the trigPin
      digitalWrite(trigPin, LOW);
      delay(3000);
      // Sets the trigPin on HIGH state for 10 micro seconds
      digitalWrite(trigPin, HIGH);
      delayMicroseconds(10);
      digitalWrite(trigPin, LOW);
      // Reads the echoPin, returns the sound wave travel time in microseconds
      duration = pulseIn(echoPin, HIGH);
      // Calculating the distance
      distance = (((duration * 0.0344)*10)/2);            // calcula la distancia en centimetros
      
      
      // Prints the distance on the Serial Monitor
        if (distance >= 500 || distance <= 0){  // si la distancia es mayor a 500cm o menor a 0cm 
            Serial.println("---");                  // no mide nada
        }
        else {
        // Prints the distance on the Serial Monitor
        Serial.print("Distance: ");
        Serial.print(distance);
        Serial.println(" cm ");
        }
      // processing satellital Data
      float latitude, longitude;
      gps.f_get_position(&latitude, &longitude);
      Serial.print("Latitud/Longitud: "); 
      Serial.print(latitude,5); 
      Serial.print(", "); 
      Serial.println(longitude,5);


  gps.crack_datetime(&year,&month,&day,&hour,&minute,&second,&hundredths);
      Serial.print("Fecha: "); Serial.print(day, DEC); Serial.print("/"); 
      Serial.print(month, DEC); Serial.print("/"); Serial.print(year);
      Serial.print(" Hora: "); Serial.print(hour, DEC); Serial.print(":"); 
      Serial.print(minute, DEC); Serial.print(":"); Serial.print(second, DEC); 
      Serial.print("."); Serial.println(hundredths, DEC);
      Serial.print("Altitud (metros): ");
      Serial.println(gps.f_altitude()); 
      Serial.print("Rumbo (grados): "); Serial.println(gps.f_course()); 
      Serial.print("Velocidad(kmph): ");
      Serial.println(gps.f_speed_kmph());
      Serial.print("Satelites: "); Serial.println(gps.satellites());
      Serial.println();
      gps.stats(&chars, &sentences, &failed_checksum);  
    }
  }
}

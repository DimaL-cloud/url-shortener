# url-shortener
URL Shortener Service

## Stack 💻
Java, Spring Boot, Lombok, Redis

## System design diagram 💡

![UrlShortenerSystemDesign](https://github.com/DimaL-cloud/url-shortener/assets/78265212/16193f2a-9ff3-4821-a988-ba81a270a7b1)

## Details
For storing hash and url Redis is used because of fast key-value storage. For hashing it uses SHA-256 from Google Guava library.

## Installation

1. Clone the repository:
```
git clone https://github.com/DimaL-cloud/url-shortener.git
```
2. Navigate to the project directory:
```
cd url-shortener
```
3. Build the project using Maven:
```
mvn clean package
```
4. Start Redis using Docker Compose:
```
docker-compose up -d
```
5. Run the Spring Boot app:
```
java -jar target/url-shortener-1.0.0.jar
```

## API
* POST /api/url
```
{
  "url": "https://example.com/url"
}
```
* GET /api/url/{hash}

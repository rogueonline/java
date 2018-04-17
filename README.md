# java stuff

**URLShortener.java** encode/decode numbers to make it shorter

\
**Checksum.java** 
* usage
```javascript
Checksum.digest(Checksum.Algorithm.MD5, "hello world".getBytes();
Checksum.digest(Checksum.Algorithm.SHA_1, "hello world".getBytes();
Checksum.digest(Checksum.Algorithm.SHA_256, "hello world".getBytes();
Checksum.digest(Checksum.Algorithm.SHA_512, "hello world".getBytes();
```

\
**CaesarCipher.java** basic encryption by shifting alphabet
* usage
```javascript
CaesarCipher.encrypt("helloworld", 3);
CaesarCipher.decrypt("ebiiltloia", 3);
```

\
**VigenereCipher.java** basic encryption using
* usage
```javascript
VigenereCipher.encrypt("helloworld", "crypto");
VigenereCipher.decrypt("jvjahkqijs", "crypto");
```

package luongnvpk.helper;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;

import Config.Config;

public class AuthenHelper {
	public static String signJwt(String ObjectJson) {
		try {
			Algorithm algorithm = Algorithm.HMAC512(Config.getCofig().jwt());
			String token = JWT.create().withIssuer(ObjectJson).sign(algorithm);
			return token;
		} catch (JWTCreationException exception) {
			System.out.println(exception);
			// Invalid Signing configuration / Couldn't convert Claims.
		}
		return "";
	}
	
	public static boolean veryJWT(String ObjectJson,String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC512(Config.getCofig().jwt());
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(ObjectJson)
		        .build();
		    DecodedJWT jwt = verifier.verify(token);
		    return true;
		} catch (JWTVerificationException exception){
		    System.out.println(exception);
		    return false;
		}
	}
}

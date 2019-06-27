package aes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Formatter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class security {

	public static void main(String[] args) {

		String jiami = "你说嘴巴嘟嘟嘟嘟嘟嘟嘟";
		System.out.println("明文：" + jiami);
		try {
			String jiamiout = encryptAES(jiami);
			System.out.println("密文：" + jiamiout);
			String jiemiout = decryptAES(jiamiout);
			System.out.println("解密：" + jiemiout);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		commonsCodecBase64();
		try {
			System.out.println(getMD5("wahahahhahahahha"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(getMD5("0ahahahhahahahha1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(getMd5x("0ahahahhahahahha1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(getMd5x("0ahahahhahahahha1").equals(getMD5("0ahahahhahahahha1"))) {
				System.out.println("鉴权通过！！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(!getMd5x("ahahahhahahahha1").equals(getMD5("0ahahahhahahahha1"))) {
				System.out.println("鉴权通过！！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ("数据加密 plainTextData要加密的字符串")
	public static String encryptAES(String plainTextData) throws Exception {
		// 测试密钥
		String key = "A+qpmAllbhxW+N4emc2Gzw==";

		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// kgen.init(128, new SecureRandom(key.getBytes()));
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(key.getBytes());
		kgen.init(128, secureRandom);
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		System.out.println("raw:" + new String(raw));
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		// 加密数据
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encryptedData = cipher.doFinal(plainTextData.getBytes("UTF-8"));

		return Base64.encodeBase64String(encryptedData);
	}

	// ("数据加密 encryptedData要解密的字符串")
	public static String decryptAES(String encryptedData) throws Exception {

		// 测试秘钥
		String key = "A+qpmAllbhxW+N4emc2Gzw==";

		//申明AES算法
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// kgen.init(128, new SecureRandom(key.getBytes()));
		
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(key.getBytes());
		kgen.init(128, secureRandom);

		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		// 解密数据
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decryptedData = cipher.doFinal(Base64.decodeBase64(encryptedData));

		return new String(decryptedData, "UTF-8");
	}
	public static void commonsCodecBase64() {
		String str =  "dizhigangdizhigangdizhigangdizhigang";
		String str1 = "dizhiGangdizhigangdizhigangdizhigang";
		Base64 base = new Base64();
		try {
			
			byte[] outstr = base.encode(str.getBytes());
			byte[] outstr1 = base.encode(str1.getBytes());
			
			System.out.println(outstr);
			System.out.println(outstr1);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
	public static String getMD5(String str) throws Exception {
		
		MessageDigest dig = MessageDigest.getInstance("MD5");
		
		dig.update(str.getBytes());
		
		return new String (dig.digest());
				//new BigInteger(1, dig.digest()).toString(16);
	}
	
	public static String toHexString(byte[] bytes) throws Exception{
		
		Formatter format = new  Formatter();
		
		for(byte bb :bytes){
			format.format("%02x", bb);
		}
		
		String res = format.toString();
		format.close();
		return res;
		
	}
	public static String getMd5x(String res) throws Exception {
		MessageDigest dig = MessageDigest.getInstance("MD5");
		dig.update(res.getBytes());
		
		return toHexString(dig.digest());
	}

}

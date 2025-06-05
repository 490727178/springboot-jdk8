package com.example.springbootlogback.utils;


import java.util.HashMap;
import java.util.UUID;

/**
 * @Description Generate  uuid util
 * @Author Mico
 * @Date 2024/11/25 下午4:20
 */
public class UUIDUtil {
    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generate16BitUUID() {
        UUID uuid = UUID.randomUUID();
        // Take the first 16 bits of the UUID
        long mostSignificantBits = uuid.getMostSignificantBits();
        // Convert to a 16-bit hexadecimal string, preceded by zeros if less than 16 bits
        return String.format("%016x", mostSignificantBits);
    }


    public static void main(String[] args) throws Exception {
        String secret = "198eecfd0d154845";
//        String iv = UUIDUtil.generate16BitUUID(、);
//        System.out.println("Q1:"+UUIDUtil.generate16BitUUID());
//        System.out.println("Q2:"+UUIDUtil.generate16BitUUID());
//        System.out.println("Q3:"+UUIDUtil.generate16BitUUID());
//        System.out.println("Q4:"+UUIDUtil.generate16BitUUID());
        HashMap<String , String> map = new HashMap<>();
//        map.put("username","pdivr");
//        map.put("password","passivr");
//        map.put("source","IVR");
//        map.put("searchType","DOCUMENT");
//        map.put("lang","EN");
//        map.put("idDocType","HKID");
//        map.put("idDocNum","000006*");
//        map.put("type","HKID");
//        map.put("num","E000279(A)");
//        System.out.println(JSON.toJSONString(map));
//        String encryptAES = EncryptUtil.encryptAES(secret, JSON.toJSONString(map), iv);
//        System.out.println(encryptAES);
//        System.out.println(iv);
//        HashMap<String , String> map1 = new HashMap<>();
//        map1.put("iv",iv);
//        map1.put("keyLabel","TheClub_Q1");
//        map1.put("data",encryptAES);
//        System.out.println(new String(Base64.getUrlEncoder().encode(JSON.toJSONString(map1).getBytes(StandardCharsets.UTF_8))));
//        String mobileNum= "aiccUid=173641613880960445981083281341&searchType=mobileNum&searchValue=13642310685" ;
//        String email= "aiccUid=173641613880960445981083281341&searchType=email&searchValue=yu2921162@qq.com" ;
//        String memberId= "aiccUid=173641613880960445981083281341&searchType=&searchValue=" ;
//        String iv = "52f6cfb770a74ce7";
//        String mobileNumData = EncryptUtil.encryptAES(secret, mobileNum, iv);
//        String mobileNumRequest = "data=" + mobileNumData+"&keyLabel=TheClub_Q4&iv="+iv;
//        String mobileNumEncoded = new String(Base64.getUrlEncoder().encode(mobileNumRequest.getBytes(StandardCharsets.UTF_8)));
//
//        String emailData = EncryptUtil.encryptAES(secret, email, iv);
//        String emailRequest = "data=" + emailData+"&keyLabel=TheClub_Q4&iv="+iv;
//        String emailEncoded = new String(Base64.getUrlEncoder().encode(emailRequest.getBytes(StandardCharsets.UTF_8)));
//
//        String memberIdData = EncryptUtil.encryptAES(secret, memberId, iv);
//        String memberIdRequest = "data=" + memberIdData+"&keyLabel=TheClub_Q1&iv="+iv;
//        String memberIdEncoded = new String(Base64.getUrlEncoder().encode(memberIdRequest.getBytes(StandardCharsets.UTF_8)));
//        System.out.println(mobileNumRequest);
//        System.out.println("mobileNumBase64: "+mobileNumEncoded);
//
//        System.out.println(emailRequest);
//        System.out.println("emailBase64: "+emailEncoded);
//
//        System.out.println(memberIdRequest);
//        System.out.println("memberIdBase64: "+memberIdEncoded);
//        String s1="198eecfd0d154845";
//        String s2="04cfa235944241fd";
//        String s3="bbee5a562810437d";
//        String s4="9041bc0c94834846";
//        String s5="MTk4ZWVjZmQwZDE1NDg0NQ==";
//        String s6="MDRjZmEyMzU5NDQyNDFmZA==";
//        String s7="YmJlZTVhNTYyODEwNDM3ZA==";
//        String s8="OTA0MWJjMGM5NDgzNDg0Ng==";
//        System.out.println(Base64.getEncoder().encodeToString(s1.getBytes()));
//        System.out.println(Base64.getEncoder().encodeToString(s2.getBytes()));
//        System.out.println(Base64.getEncoder().encodeToString(s3.getBytes()));
//        System.out.println(Base64.getEncoder().encodeToString(s4.getBytes()));
//        System.out.println(new String(Base64.getDecoder().decode(s5.getBytes())));
//        System.out.println(new String(Base64.getDecoder().decode(s6.getBytes())));
//        System.out.println(new String(Base64.getDecoder().decode(s7.getBytes())));
//        System.out.println(new String(Base64.getDecoder().decode(s8.getBytes())));
//
//
//        String CIM_Q1 = "DmEf94/lDPXhFW2eg4ZTJYPY2DGbQl7uAu7M9cMY1Q0=";
//        System.out.println(new String(Base64.getDecoder().decode(CIM_Q1.getBytes(StandardCharsets.UTF_8))));
//        String data = "{\"data\":\"xT1aOrKKpdfyXdOXB3pg+eyIe1Y3jcqlaYAIqrOdNKywWFkt+qZlcyCmTst8jcVce4GBGf5xvyiP6oXKiLmyCn8XHqOfJipo73A5nFuahwI0i5GJRvV+/KcbGbM3fxYKW+shIqJ9UDpwKei62w5a60DcPJNi83KpMNYX3Rfp7qpzcFRLkwrqKNLG9JJxipFbwcViOWBuM4BbDQ7PULENt6HuN8lHWD+1PxT4cE90lgSoUS9uRZNKC/ZRr8TkRnhYb33qB7O8Edeh4z098ERjnG5uSIASo5sWXDgxIgCyQCK3qNLfsHo0IpTeBhlFE0fuluDU3tdOm1wkq9kTm6WE+WWjIVlltb7Te/wnFigbnad9gebRYs8FHT3OK8BJnfpPafBEC5mYNpktPMlJQ0q8o2VKi6HqW+kxEMcLK9Pr2JJ5mnvudd4hLm2jhOD5TDlceC431Lt+7gfnT7hB+lCsR5ikDxSpYTD4lVLPubal50efHe6A97Qyz4v0Z52NMfzvjudKOoTQJC0ffNL8uwOHCaJf8YWixrdP3k4PymLE+jGKm1vK0gsc7fyT7QVommM0qMLElCdSykPO34k25e/hhLzE44Fg3mIrWhraefq8cG+imN9YFdys4TviwcF0M7Q2NI7JLfqsawUaAGKG1x4vc2vA/pMgR1zPvjOpawTMlR5yMuuPaEu64fezgK0nRFCdgrKQI1PQ/7ZAecKVdb9YfGWY8kUj7B5wZa4Vl3lXCyPAjCpHW+S/VzXlnmbuoGPtrBwFDQeDtSlE0xAPY/5NQ1MSgIdWQYaMdVsjCq0R4bQ1SeIzzrIgEpWP3QKHSYdOSz2ytxnUUYdQPVE3yIHPs7VOkx3TcAQpJL5bsNwyRUIVgE8pw7oCiiGS7hUIMdr+p5jn50v2VzDMZpfJUrRzrERFUD6NWv3eFOlEunoLWxyYYlnarh8RPj1S2asw1uuQnOlHlasvX5qc5HnLfaW4IepUaLSpSoYxBYU0l7JNTemtulAYA4ULCG8fPqAM7Fzr\",\"iv\":\"b6a594f1212444a3\",\"keyLabel\":\"TheClub_Q4\"}";
//        Map<String, String> map2 = JSON.parseObject(data, Map.class);
//        String keyLabel = "TheClub_Q4";
//        String iv1 = "b6a594f1212444a3";
//        System.out.println(EncryptUtil.decryptAES(secret,  map2.get("data"),map2.get("iv")));

//        String data = "2Nnz3ET7IBNOtQ5d6a0Zi6quYieshN2pnwz+IHHVY1a371SjcFmDh9t4xv0HHvyA2Vdu2u/kIFGg183v2pVfv7GHBTJBZGm/YwevQ/XqAveTijhxNnq2Zqv9wRTDeDPS";
//        String iv1 = "A970196C186649B3";
//        String decryptAES = EncryptUtil.decryptAES(secret, data, iv1);
//        System.out.println(decryptAES);
//        String password = "Ymt3b05FbXZwcXdfMTU1ODU3NTE3MlBXMWM0ODIw";
//        String username = "UENMVUJSV0RDT04x";
//        System.out.println(new String(Base64.getDecoder().decode(password.getBytes(StandardCharsets.UTF_8))));
//        System.out.println(new String(Base64.getDecoder().decode(username.getBytes(StandardCharsets.UTF_8))));
//        System.out.println(new String(Base64.getDecoder().decode("eyJkYXRhIjoiWkpGa2NYZHlhMnZmOUZHZ2FxdWVCZlE3LzNRQXQ4OHpIRWw1ek1EQWlFcz0iLCJpdiI6IkEzRTIwOTQ5MjVBNTREMEQiLCJrZXlMYWJlbCI6IlRoZUNsdWJfUTEifQ==".getBytes(StandardCharsets.UTF_8))));
//        String s = new String(Base64.getDecoder().decode("UENMVUJSV0RDT04y"));
//        String s1 = new String(Base64.getDecoder().decode("UGQwNl9lMTU1OTI3NDk0OGJJa1NxMXJXMDJGUXdr"));
//        System.out.println(s);
//        System.out.println(s1);
//        Hashtable<String, Integer> scoretable = new Hashtable<String, Integer>();
//        Hashtable<String, String> columntable = new Hashtable<String, String>();
//        scoretable.put("country_code",Integer.parseInt("004"));
//        scoretable.put("subchannel",Integer.parseInt("002"));
//        scoretable.put("tier",Integer.parseInt("001"));
//        columntable.put("country_code","VALUE1");
//        columntable.put("subchannel","VALUE2");
//        columntable.put("tier","LOB");
//        Hashtable<String, String> entrytable = new Hashtable<String, String>();
//
//        entrytable.put("country_code", "ALL");
//        entrytable.put("subchannel", "ALL");
//        entrytable.put("tier", "ALL");
//
//        Enumeration<String> keys = scoretable.keys();
//        while (keys.hasMoreElements()) {
//            String key = keys.nextElement();
//            System.out.println(key + ":" + scoretable.get(key));
//        }
//        int maxscore = 0;
//        int curscore = 0;
//
//        Iterator<Integer> itr = scoretable.values().iterator();
//
//        while(itr.hasNext()){
//            maxscore += itr.next() * 2;
//        }
//        System.out.println(maxscore);

//        String basr64str = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPCEtLQogIExpY2Vuc2VkIHRvIHRoZSBBcGFjaGUgU29mdHdhcmUgRm91bmRhdGlvbiAoQVNGKSB1bmRlciBvbmUgb3IgbW9yZQogIGNvbnRyaWJ1dG9yIGxpY2Vuc2UgYWdyZWVtZW50cy4gIFNlZSB0aGUgTk9USUNFIGZpbGUgZGlzdHJpYnV0ZWQgd2l0aAogIHRoaXMgd29yayBmb3IgYWRkaXRpb25hbCBpbmZvcm1hdGlvbiByZWdhcmRpbmcgY29weXJpZ2h0IG93bmVyc2hpcC4KICBUaGUgQVNGIGxpY2Vuc2VzIHRoaXMgZmlsZSB0byBZb3UgdW5kZXIgdGhlIEFwYWNoZSBMaWNlbnNlLCBWZXJzaW9uIDIuMAogICh0aGUgIkxpY2Vuc2UiKTsgeW91IG1heSBub3QgdXNlIHRoaXMgZmlsZSBleGNlcHQgaW4gY29tcGxpYW5jZSB3aXRoCiAgdGhlIExpY2Vuc2UuICBZb3UgbWF5IG9idGFpbiBhIGNvcHkgb2YgdGhlIExpY2Vuc2UgYXQKCiAgICAgIGh0dHA6Ly93d3cuYXBhY2hlLm9yZy9saWNlbnNlcy9MSUNFTlNFLTIuMCAKCiAgVW5sZXNzIHJlcXVpcmVkIGJ5IGFwcGxpY2FibGUgbGF3IG9yIGFncmVlZCB0byBpbiB3cml0aW5nLCBzb2Z0d2FyZQogIGRpc3RyaWJ1dGVkIHVuZGVyIHRoZSBMaWNlbnNlIGlzIGRpc3RyaWJ1dGVkIG9uIGFuICJBUyBJUyIgQkFTSVMsCiAgV0lUSE9VVCBXQVJSQU5USUVTIE9SIENPTkRJVElPTlMgT0YgQU5ZIEtJTkQsIGVpdGhlciBleHByZXNzIG9yIGltcGxpZWQuCiAgU2VlIHRoZSBMaWNlbnNlIGZvciB0aGUgc3BlY2lmaWMgbGFuZ3VhZ2UgZ292ZXJuaW5nIHBlcm1pc3Npb25zIGFuZAogIGxpbWl0YXRpb25zIHVuZGVyIHRoZSBMaWNlbnNlLgotLT4KPCEtLSBOb3RlOiAgQSAiU2VydmVyIiBpcyBub3QgaXRzZWxmIGEgIkNvbnRhaW5lciIsIHNvIHlvdSBtYXkgbm90CiAgICAgZGVmaW5lIHN1YmNvbXBvbmVudHMgc3VjaCBhcyAiVmFsdmVzIiBhdCB0aGlzIGxldmVsLgogICAgIERvY3VtZW50YXRpb24gYXQgL2RvY3MvY29uZmlnL3NlcnZlci5odG1sCiAtLT4KPFNlcnZlciBwb3J0PSI4MDA1IiBzaHV0ZG93bj0iU0hVVERPV04iPgogIDxMaXN0ZW5lciBjbGFzc05hbWU9Im9yZy5hcGFjaGUuY2F0YWxpbmEuc3RhcnR1cC5WZXJzaW9uTG9nZ2VyTGlzdGVuZXIiIC8+CiAgPCEtLSBTZWN1cml0eSBsaXN0ZW5lci4gRG9jdW1lbnRhdGlvbiBhdCAvZG9jcy9jb25maWcvbGlzdGVuZXJzLmh0bWwKICA8TGlzdGVuZXIgY2xhc3NOYW1lPSJvcmcuYXBhY2hlLmNhdGFsaW5hLnNlY3VyaXR5LlNlY3VyaXR5TGlzdGVuZXIiIC8+CiAgLS0+CiAgPCEtLUFQUiBsaWJyYXJ5IGxvYWRlci4gRG9jdW1lbnRhdGlvbiBhdCAvZG9jcy9hcHIuaHRtbCAtLT4KICA8TGlzdGVuZXIgY2xhc3NOYW1lPSJvcmcuYXBhY2hlLmNhdGFsaW5hLmNvcmUuQXByTGlmZWN5Y2xlTGlzdGVuZXIiIFNTTEVuZ2luZT0ib24iIC8+CiAgPCEtLSBQcmV2ZW50IG1lbW9yeSBsZWFrcyBkdWUgdG8gdXNlIG9mIHBhcnRpY3VsYXIgamF2YS9qYXZheCBBUElzLS0+CiAgPExpc3RlbmVyIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5jb3JlLkpyZU1lbW9yeUxlYWtQcmV2ZW50aW9uTGlzdGVuZXIiIC8+CiAgPExpc3RlbmVyIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5tYmVhbnMuR2xvYmFsUmVzb3VyY2VzTGlmZWN5Y2xlTGlzdGVuZXIiIC8+CiAgPExpc3RlbmVyIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5jb3JlLlRocmVhZExvY2FsTGVha1ByZXZlbnRpb25MaXN0ZW5lciIgLz4KCiAgPCEtLSBHbG9iYWwgSk5ESSByZXNvdXJjZXMKICAgICAgIERvY3VtZW50YXRpb24gYXQgL2RvY3Mvam5kaS1yZXNvdXJjZXMtaG93dG8uaHRtbAogIC0tPgogIDxHbG9iYWxOYW1pbmdSZXNvdXJjZXM+CiAgICA8UmVzb3VyY2UgbmFtZT0iVXNlckRhdGFiYXNlIiBhdXRoPSJDb250YWluZXIiCiAgICAgICAgICAgICAgdHlwZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5Vc2VyRGF0YWJhc2UiCiAgICAgICAgICAgICAgZGVzY3JpcHRpb249IlVzZXIgZGF0YWJhc2UgdGhhdCBjYW4gYmUgdXBkYXRlZCBhbmQgc2F2ZWQiCiAgICAgICAgICAgICAgZmFjdG9yeT0ib3JnLmFwYWNoZS5jYXRhbGluYS51c2Vycy5NZW1vcnlVc2VyRGF0YWJhc2VGYWN0b3J5IgogICAgICAgICAgICAgIHBhdGhuYW1lPSJjb25mL3RvbWNhdC11c2Vycy54bWwiIC8+CiAgICA8UmVzb3VyY2UgbmFtZT0iamRiYy9wZEFETSIKICAgICAgYXV0aD0iQ29udGFpbmVyIgogICAgICB0eXBlPSJqYXZheC5zcWwuRGF0YVNvdXJjZSIKICAgICAgbWF4VG90YWw9IjEwMCIKICAgICAgbWF4SWRsZT0iMzAiCiAgICAgIG1heFdhaXRNaWxsaXM9IjEwMDAwIgogICAgICB1c2VybmFtZT0iUENMVUJSV0RDT04yIgogICAgICBwYXNzd29yZD0iUGQwNl9lMTU1OTI3NDk0OGJJa1NxMXJXMDJGUXdrIgogICAgICBkcml2ZXJDbGFzc05hbWU9Im9yYWNsZS5qZGJjLmRyaXZlci5PcmFjbGVEcml2ZXIiCiAgICAgIHVybD0iamRiYzpvcmFjbGU6dGhpbjpAKERFU0NSSVBUSU9OID0gKEFERFJFU1MgPSAoUFJPVE9DT0wgPSBUQ1ApKEhPU1QgPSBQQ0xVQi5vcmFjbGUuc2Nhbi5wY2N3LmNvbSkoUE9SVCA9IDE1MjEpKShDT05ORUNUX0RBVEEgPSAoU0VSVkVSID0gREVESUNBVEVEKShTRVJWSUNFX05BTUUgPSB0cGNkYmNicDE5Yy5zNzQ4MDg4Ny5vcmFjbGVjbG91ZGF0Y3VzdG9tZXIuY29tKShGQUlMT1ZFUl9NT0RFID0gKFRZUEUgPSBzZWxlY3QpKE1FVEhPRCA9IGJhc2ljKSkpKSIgLz4KICA8L0dsb2JhbE5hbWluZ1Jlc291cmNlcz4KCiAgPCEtLSBBICJTZXJ2aWNlIiBpcyBhIGNvbGxlY3Rpb24gb2Ygb25lIG9yIG1vcmUgIkNvbm5lY3RvcnMiIHRoYXQgc2hhcmUKICAgICAgIGEgc2luZ2xlICJDb250YWluZXIiIE5vdGU6ICBBICJTZXJ2aWNlIiBpcyBub3QgaXRzZWxmIGEgIkNvbnRhaW5lciIsCiAgICAgICBzbyB5b3UgbWF5IG5vdCBkZWZpbmUgc3ViY29tcG9uZW50cyBzdWNoIGFzICJWYWx2ZXMiIGF0IHRoaXMgbGV2ZWwuCiAgICAgICBEb2N1bWVudGF0aW9uIGF0IC9kb2NzL2NvbmZpZy9zZXJ2aWNlLmh0bWwKICAgLS0+CiAgPFNlcnZpY2UgbmFtZT0iQ2F0YWxpbmEiPgoKICAgIDwhLS1UaGUgY29ubmVjdG9ycyBjYW4gdXNlIGEgc2hhcmVkIGV4ZWN1dG9yLCB5b3UgY2FuIGRlZmluZSBvbmUgb3IgbW9yZSBuYW1lZCB0aHJlYWQgcG9vbHMtLT4KICAgIDwhLS0KICAgIDxFeGVjdXRvciBuYW1lPSJ0b21jYXRUaHJlYWRQb29sIiBuYW1lUHJlZml4PSJjYXRhbGluYS1leGVjLSIKICAgICAgICBtYXhUaHJlYWRzPSIxNTAiIG1pblNwYXJlVGhyZWFkcz0iNCIvPgogICAgLS0+CgoKICAgIDwhLS0gQSAiQ29ubmVjdG9yIiByZXByZXNlbnRzIGFuIGVuZHBvaW50IGJ5IHdoaWNoIHJlcXVlc3RzIGFyZSByZWNlaXZlZAogICAgICAgICBhbmQgcmVzcG9uc2VzIGFyZSByZXR1cm5lZC4gRG9jdW1lbnRhdGlvbiBhdCA6CiAgICAgICAgIEphdmEgSFRUUCBDb25uZWN0b3I6IC9kb2NzL2NvbmZpZy9odHRwLmh0bWwKICAgICAgICAgSmF2YSBBSlAgIENvbm5lY3RvcjogL2RvY3MvY29uZmlnL2FqcC5odG1sCiAgICAgICAgIEFQUiAoSFRUUC9BSlApIENvbm5lY3RvcjogL2RvY3MvYXByLmh0bWwKICAgICAgICAgRGVmaW5lIGEgbm9uLVNTTC9UTFMgSFRUUC8xLjEgQ29ubmVjdG9yIG9uIHBvcnQgODA4MAogICAgLS0+CiAgICA8Q29ubmVjdG9yIHBvcnQ9IjgwODAiIHByb3RvY29sPSJIVFRQLzEuMSIKICAgICAgICAgICAgICAgY29ubmVjdGlvblRpbWVvdXQ9IjIwMDAwIgogICAgICAgICAgICAgICByZWRpcmVjdFBvcnQ9Ijg0NDMiIC8+CiAgICA8IS0tIEEgIkNvbm5lY3RvciIgdXNpbmcgdGhlIHNoYXJlZCB0aHJlYWQgcG9vbC0tPgogICAgPCEtLQogICAgPENvbm5lY3RvciBleGVjdXRvcj0idG9tY2F0VGhyZWFkUG9vbCIKICAgICAgICAgICAgICAgcG9ydD0iODA4MCIgcHJvdG9jb2w9IkhUVFAvMS4xIgogICAgICAgICAgICAgICBjb25uZWN0aW9uVGltZW91dD0iMjAwMDAiCiAgICAgICAgICAgICAgIHJlZGlyZWN0UG9ydD0iODQ0MyIgLz4KICAgIC0tPgogICAgPCEtLSBEZWZpbmUgYW4gU1NML1RMUyBIVFRQLzEuMSBDb25uZWN0b3Igb24gcG9ydCA4NDQzCiAgICAgICAgIFRoaXMgY29ubmVjdG9yIHVzZXMgdGhlIE5JTyBpbXBsZW1lbnRhdGlvbi4gVGhlIGRlZmF1bHQKICAgICAgICAgU1NMSW1wbGVtZW50YXRpb24gd2lsbCBkZXBlbmQgb24gdGhlIHByZXNlbmNlIG9mIHRoZSBBUFIvbmF0aXZlCiAgICAgICAgIGxpYnJhcnkgYW5kIHRoZSB1c2VPcGVuU1NMIGF0dHJpYnV0ZSBvZiB0aGUKICAgICAgICAgQXByTGlmZWN5Y2xlTGlzdGVuZXIuCiAgICAgICAgIEVpdGhlciBKU1NFIG9yIE9wZW5TU0wgc3R5bGUgY29uZmlndXJhdGlvbiBtYXkgYmUgdXNlZCByZWdhcmRsZXNzIG9mCiAgICAgICAgIHRoZSBTU0xJbXBsZW1lbnRhdGlvbiBzZWxlY3RlZC4gSlNTRSBzdHlsZSBjb25maWd1cmF0aW9uIGlzIHVzZWQgYmVsb3cuCiAgICAtLT4KICAgIDwhLS0KICAgIDxDb25uZWN0b3IgcG9ydD0iODQ0MyIgcHJvdG9jb2w9Im9yZy5hcGFjaGUuY295b3RlLmh0dHAxMS5IdHRwMTFOaW9Qcm90b2NvbCIKICAgICAgICAgICAgICAgbWF4VGhyZWFkcz0iMTUwIiBTU0xFbmFibGVkPSJ0cnVlIj4KICAgICAgICA8U1NMSG9zdENvbmZpZz4KICAgICAgICAgICAgPENlcnRpZmljYXRlIGNlcnRpZmljYXRlS2V5c3RvcmVGaWxlPSJjb25mL2xvY2FsaG9zdC1yc2EuamtzIgogICAgICAgICAgICAgICAgICAgICAgICAgdHlwZT0iUlNBIiAvPgogICAgICAgIDwvU1NMSG9zdENvbmZpZz4KICAgIDwvQ29ubmVjdG9yPgogICAgLS0+CiAgICA8IS0tIERlZmluZSBhbiBTU0wvVExTIEhUVFAvMS4xIENvbm5lY3RvciBvbiBwb3J0IDg0NDMgd2l0aCBIVFRQLzIKICAgICAgICAgVGhpcyBjb25uZWN0b3IgdXNlcyB0aGUgQVBSL25hdGl2ZSBpbXBsZW1lbnRhdGlvbiB3aGljaCBhbHdheXMgdXNlcwogICAgICAgICBPcGVuU1NMIGZvciBUTFMuCiAgICAgICAgIEVpdGhlciBKU1NFIG9yIE9wZW5TU0wgc3R5bGUgY29uZmlndXJhdGlvbiBtYXkgYmUgdXNlZC4gT3BlblNTTCBzdHlsZQogICAgICAgICBjb25maWd1cmF0aW9uIGlzIHVzZWQgYmVsb3cuCiAgICAtLT4KICAgIDwhLS0KICAgIDxDb25uZWN0b3IgcG9ydD0iODQ0MyIgcHJvdG9jb2w9Im9yZy5hcGFjaGUuY295b3RlLmh0dHAxMS5IdHRwMTFBcHJQcm90b2NvbCIKICAgICAgICAgICAgICAgbWF4VGhyZWFkcz0iMTUwIiBTU0xFbmFibGVkPSJ0cnVlIiA+CiAgICAgICAgPFVwZ3JhZGVQcm90b2NvbCBjbGFzc05hbWU9Im9yZy5hcGFjaGUuY295b3RlLmh0dHAyLkh0dHAyUHJvdG9jb2wiIC8+CiAgICAgICAgPFNTTEhvc3RDb25maWc+CiAgICAgICAgICAgIDxDZXJ0aWZpY2F0ZSBjZXJ0aWZpY2F0ZUtleUZpbGU9ImNvbmYvbG9jYWxob3N0LXJzYS1rZXkucGVtIgogICAgICAgICAgICAgICAgICAgICAgICAgY2VydGlmaWNhdGVGaWxlPSJjb25mL2xvY2FsaG9zdC1yc2EtY2VydC5wZW0iCiAgICAgICAgICAgICAgICAgICAgICAgICBjZXJ0aWZpY2F0ZUNoYWluRmlsZT0iY29uZi9sb2NhbGhvc3QtcnNhLWNoYWluLnBlbSIKICAgICAgICAgICAgICAgICAgICAgICAgIHR5cGU9IlJTQSIgLz4KICAgICAgICA8L1NTTEhvc3RDb25maWc+CiAgICA8L0Nvbm5lY3Rvcj4KICAgIC0tPgoKICAgIDwhLS0gRGVmaW5lIGFuIEFKUCAxLjMgQ29ubmVjdG9yIG9uIHBvcnQgODAwOSAtLT4KICAgIDwhLS0KICAgIDxDb25uZWN0b3IgcHJvdG9jb2w9IkFKUC8xLjMiCiAgICAgICAgICAgICAgIGFkZHJlc3M9Ijo6MSIKICAgICAgICAgICAgICAgcG9ydD0iODAwOSIKICAgICAgICAgICAgICAgcmVkaXJlY3RQb3J0PSI4NDQzIiAvPgogICAgLS0+CgogICAgPCEtLSBBbiBFbmdpbmUgcmVwcmVzZW50cyB0aGUgZW50cnkgcG9pbnQgKHdpdGhpbiBDYXRhbGluYSkgdGhhdCBwcm9jZXNzZXMKICAgICAgICAgZXZlcnkgcmVxdWVzdC4gIFRoZSBFbmdpbmUgaW1wbGVtZW50YXRpb24gZm9yIFRvbWNhdCBzdGFuZCBhbG9uZQogICAgICAgICBhbmFseXplcyB0aGUgSFRUUCBoZWFkZXJzIGluY2x1ZGVkIHdpdGggdGhlIHJlcXVlc3QsIGFuZCBwYXNzZXMgdGhlbQogICAgICAgICBvbiB0byB0aGUgYXBwcm9wcmlhdGUgSG9zdCAodmlydHVhbCBob3N0KS4KICAgICAgICAgRG9jdW1lbnRhdGlvbiBhdCAvZG9jcy9jb25maWcvZW5naW5lLmh0bWwgLS0+CgogICAgPCEtLSBZb3Ugc2hvdWxkIHNldCBqdm1Sb3V0ZSB0byBzdXBwb3J0IGxvYWQtYmFsYW5jaW5nIHZpYSBBSlAgaWUgOgogICAgPEVuZ2luZSBuYW1lPSJDYXRhbGluYSIgZGVmYXVsdEhvc3Q9ImxvY2FsaG9zdCIganZtUm91dGU9Imp2bTEiPgogICAgLS0+CiAgICA8RW5naW5lIG5hbWU9IkNhdGFsaW5hIiBkZWZhdWx0SG9zdD0ibG9jYWxob3N0Ij4KCiAgICAgIDwhLS1Gb3IgY2x1c3RlcmluZywgcGxlYXNlIHRha2UgYSBsb29rIGF0IGRvY3VtZW50YXRpb24gYXQ6CiAgICAgICAgICAvZG9jcy9jbHVzdGVyLWhvd3RvLmh0bWwgIChzaW1wbGUgaG93IHRvKQogICAgICAgICAgL2RvY3MvY29uZmlnL2NsdXN0ZXIuaHRtbCAocmVmZXJlbmNlIGRvY3VtZW50YXRpb24pIC0tPgogICAgICA8IS0tCiAgICAgIDxDbHVzdGVyIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5oYS50Y3AuU2ltcGxlVGNwQ2x1c3RlciIvPgogICAgICAtLT4KCiAgICAgIDwhLS0gVXNlIHRoZSBMb2NrT3V0UmVhbG0gdG8gcHJldmVudCBhdHRlbXB0cyB0byBndWVzcyB1c2VyIHBhc3N3b3JkcwogICAgICAgICAgIHZpYSBhIGJydXRlLWZvcmNlIGF0dGFjayAtLT4KICAgICAgPFJlYWxtIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS5yZWFsbS5Mb2NrT3V0UmVhbG0iPgogICAgICAgIDwhLS0gVGhpcyBSZWFsbSB1c2VzIHRoZSBVc2VyRGF0YWJhc2UgY29uZmlndXJlZCBpbiB0aGUgZ2xvYmFsIEpOREkKICAgICAgICAgICAgIHJlc291cmNlcyB1bmRlciB0aGUga2V5ICJVc2VyRGF0YWJhc2UiLiAgQW55IGVkaXRzCiAgICAgICAgICAgICB0aGF0IGFyZSBwZXJmb3JtZWQgYWdhaW5zdCB0aGlzIFVzZXJEYXRhYmFzZSBhcmUgaW1tZWRpYXRlbHkKICAgICAgICAgICAgIGF2YWlsYWJsZSBmb3IgdXNlIGJ5IHRoZSBSZWFsbS4gIC0tPgogICAgICAgIDxSZWFsbSBjbGFzc05hbWU9Im9yZy5hcGFjaGUuY2F0YWxpbmEucmVhbG0uVXNlckRhdGFiYXNlUmVhbG0iCiAgICAgICAgICAgICAgIHJlc291cmNlTmFtZT0iVXNlckRhdGFiYXNlIi8+CiAgICAgIDwvUmVhbG0+CgogICAgICA8SG9zdCBuYW1lPSJsb2NhbGhvc3QiICBhcHBCYXNlPSJ3ZWJhcHBzIgogICAgICAgICAgICB1bnBhY2tXQVJzPSJ0cnVlIiBhdXRvRGVwbG95PSJ0cnVlIj4KCiAgICAgICAgPCEtLSBTaW5nbGVTaWduT24gdmFsdmUsIHNoYXJlIGF1dGhlbnRpY2F0aW9uIGJldHdlZW4gd2ViIGFwcGxpY2F0aW9ucwogICAgICAgICAgICAgRG9jdW1lbnRhdGlvbiBhdDogL2RvY3MvY29uZmlnL3ZhbHZlLmh0bWwgLS0+CiAgICAgICAgPCEtLQogICAgICAgIDxWYWx2ZSBjbGFzc05hbWU9Im9yZy5hcGFjaGUuY2F0YWxpbmEuYXV0aGVudGljYXRvci5TaW5nbGVTaWduT24iIC8+CiAgICAgICAgLS0+CgogICAgICAgIDwhLS0gQWNjZXNzIGxvZyBwcm9jZXNzZXMgYWxsIGV4YW1wbGUuCiAgICAgICAgICAgICBEb2N1bWVudGF0aW9uIGF0OiAvZG9jcy9jb25maWcvdmFsdmUuaHRtbAogICAgICAgICAgICAgTm90ZTogVGhlIHBhdHRlcm4gdXNlZCBpcyBlcXVpdmFsZW50IHRvIHVzaW5nIHBhdHRlcm49ImNvbW1vbiIgLS0+CiAgICAgICAgPFZhbHZlIGNsYXNzTmFtZT0ib3JnLmFwYWNoZS5jYXRhbGluYS52YWx2ZXMuQWNjZXNzTG9nVmFsdmUiIGRpcmVjdG9yeT0ibG9ncyIKICAgICAgICAgICAgICAgcHJlZml4PSJsb2NhbGhvc3RfYWNjZXNzX2xvZyIgc3VmZml4PSIudHh0IgogICAgICAgICAgICAgICBwYXR0ZXJuPSIlaCAlbCAldSAldCAmcXVvdDslciZxdW90OyAlcyAlYiIgLz4KCiAgICAgIDwvSG9zdD4KICAgIDwvRW5naW5lPgogIDwvU2VydmljZT4KPC9TZXJ2ZXI+";
//        System.out.println(new String(Base64.getDecoder().decode(basr64str.getBytes(StandardCharsets.UTF_8))));

//        Map<String, Object> requestMap = new HashMap<>();
//        Map<String, String> hashMap = new HashMap<>();
//        requestMap.put("email", "mico.rs.zeng@pccw.com");
//        requestMap.put("ctx", hashMap);
//        hashMap.put("lastName", "shang");
//        hashMap.put("firstName", "shang");
//        hashMap.put("memberId", "8058861736");
//        System.out.println(JSON.toJSONString(requestMap));

//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("cardTypeId","-222");
//        map1.put("cardName","HKT-DEV001");
//        map1.put("cardType","GOLD");
//        map1.put("cardIssuer","CITI");
//        map1.put("association","AMEX");
//        map1.put("cardbinRange","8666-8668");
//        map1.put("linkageDate","2021-11-04T17:58:51");
//        map1.put("primSuppInd","S");
//        Map<String, Object> map2 = new HashMap<>();
//        map2.put("cardTypeId","-222");
//        map2.put("cardName","HKT-DEV001");
//        map2.put("cardType","GOLD");
//        map2.put("cardIssuer","MOX");
//        map2.put("association","AMEX");
//        map2.put("cardbinRange","8666-8668");
//        map2.put("linkageDate","2021-11-04T17:58:51");
//        map2.put("primSuppInd","S");
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(map1);
//        list.add(map2);
//        System.out.println(JSON.toJSONString(list));


    }
}

package br.com.cityconnect.integrador_sa_transportes.util;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Util {

    private static SimpleDateFormat sDtFormatHora = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat sDtFormatHoraMinuto = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat sDtFormatData = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sDtFormatDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    private final Pattern hasLowercase = Pattern.compile("[a-z]");
    private final Pattern hasNumber = Pattern.compile("\\d");
    private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
    
    
    
}
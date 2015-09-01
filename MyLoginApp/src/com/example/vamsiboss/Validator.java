package com.example.vamsiboss;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.EditText;

public class Validator {
	/**	error messages	*/
	private static final String err_has_Special_numeral = "Special char & numeral not allowed";
	private static final String err_UserNameMinLimit = "minimum 8 char";
	private static final String err_hasSpecialChar = "special characters not allowed";
	private static final String err_hasNumeral = "numeral not allowed";
	private static final String err_REQUIRED_MSG = "required";
	
	/**	regular expression	**/
	private static final String regex_hasSpecialChar = "[^A-Za-z0-9]";
	private static final String regex_hasNumeric = "[0-9]";

	public static boolean isUserName(EditText editText, boolean required) {
		boolean status = false;
		String text = editText.getText().toString();
		if (hasText(editText)) {
			if(isStringHasPattern(text, regex_hasSpecialChar) && isStringHasPattern(text, regex_hasNumeric)){
				editText.setError(err_has_Special_numeral);
			}else if (isStringHasPattern(text, regex_hasSpecialChar)) {
				editText.setError(err_hasSpecialChar);
			} else if (isStringHasPattern(text, regex_hasNumeric)) {
				editText.setError(err_hasNumeral);
			} else if (text.length() < 8) {
				editText.setError(err_UserNameMinLimit);
			} else {
				status = true;
			}
		}
		return status;
	}

	
	
	
	
	
	
	
	// return true if the input field is valid, based on the parameter passed
	public static boolean isValid(EditText editText, String regex,String errMsg, boolean required) {

		String text = editText.getText().toString().trim();
		// clearing the error, if it was previously set by some other values
		editText.setError(null);

		// text required and editText is blank, so return false
		if (required && !hasText(editText)) {
			return false;
		}
		// pattern doesn't match so returning false
		if (required && !Pattern.matches(regex, text)) {
			editText.setError(errMsg);
			return false;
		}
		return true;
	}
	// check the input field has any text or not
	// return true if it contains text otherwise false
	public static boolean hasText(EditText editText) {

		String text = editText.getText().toString().trim();
		editText.setError(null);

		// length 0 means there is no text
		if (text.length() == 0) {
			editText.setError(err_REQUIRED_MSG);
			return false;
		}

		return true;
	}

	public static boolean isStringHasPattern(String text, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		if (m.find())
			return true;
		else
			return false;
	}

}
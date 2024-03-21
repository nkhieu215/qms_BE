package com.fn.qms.base.validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fn.qms.bean.ResponseCode;

public interface Validator<T> {
	public Result validate(T value);

	public static interface Result {

		public static final Result OK = new Result() {
			@Override
			public String getMessage() {
				return "OK";
			}

			@Override
			public void setMessage(String message) {

			}

			@Override
			public String toString() {
				return "OK";
			}

			@Override
			public boolean isOk() {
				return true;
			}

			@Override
			public String getResponseCode() {
				return ResponseCode.SUCCESS.getErrorCode();
			}

			@Override
			public String getClearMessage() {
				return getMessage();
			}
		};

		public static final Result NULL = new Result() {
			@Override
			public String getMessage() {
				return "NULL";
			}

			@Override
			public void setMessage(String message) {

			}

			@Override
			public String toString() {
				return "NULL";
			}

			@Override
			public boolean isOk() {
				return false;
			}

			@Override
			public String getResponseCode() {
				return ResponseCode.NULL.getErrorCode();
			}

			@Override
			public String getClearMessage() {
				return getMessage();
			}
		};

		public static final Result UNKNOWN = new Result() {
			@Override
			public String getMessage() {
				return "UNKNOWN";
			}

			@Override
			public void setMessage(String message) {

			}

			@Override
			public String toString() {
				return "UNKNOWN";
			}

			@Override
			public boolean isOk() {
				return false;
			}

			@Override
			public String getResponseCode() {
				return ResponseCode.UNKNOWN.getErrorCode();
			}

			@Override
			public String getClearMessage() {
				return getMessage();
			}
		};

		public boolean isOk();

		public String getMessage();

		@JsonIgnore
		public String getClearMessage();

		public String getResponseCode();

		public void setMessage(String message);

	}
}

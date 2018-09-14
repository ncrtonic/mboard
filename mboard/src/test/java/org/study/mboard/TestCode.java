package org.study.mboard;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class TestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", 1)
				.queryParam("perPageNum", 5).build();

		System.out.println(uriComponents.toUriString());
	}

}

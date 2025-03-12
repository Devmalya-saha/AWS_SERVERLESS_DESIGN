package com.task03;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(
		lambdaName = "hello_world",
		roleName = "hello_world-role",
		isPublishVersion = true,
		aliasName = "${lambdas_alias_name}",
		logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		Map<String, Object> response = new HashMap<>();

		// Status code
		response.put("statusCode", 200);

		// Headers
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		response.put("headers", headers);

		// Body must be a JSON string
		response.put("body", "{\"message\": \"Hello from Lambda\"}");

		return response;
	}
}

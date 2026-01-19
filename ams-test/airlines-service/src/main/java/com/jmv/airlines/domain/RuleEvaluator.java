package com.jmv.airlines.domain;

import com.jmv.airlines.domain.exception.RuleViolationException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class RuleEvaluator {

    private final ExpressionParser parser = new SpelExpressionParser();

    public void evaluate(CustomFieldDefinition def, Map<String, Object> customFields) {

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("customFields", customFields);

        Boolean result = parser
                .parseExpression(def.getRules())
                .getValue(context, Boolean.class);

        if (Boolean.FALSE.equals(result)) {
            Object actualValue = customFields.get(def.getFieldName());
            String msg = String.format(
                    "%s must satisfy rule: %s (actual: %s)",
                    def.getFieldName(),
                    def.getRules(),
                    actualValue
            );
            throw new RuleViolationException(msg);
        }
    }

}

package com.coherentlogic.treasurydirect.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * Thrown when the type is not one of {@link Securities} or {@link Debts}.
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class UnsupportedTypeException extends NestedRuntimeException {

    private static final long serialVersionUID = -8510084516201832873L;

    public UnsupportedTypeException(Class unsupportedType) {
        super("The type " + unsupportedType + " is not supported.");
    }
}

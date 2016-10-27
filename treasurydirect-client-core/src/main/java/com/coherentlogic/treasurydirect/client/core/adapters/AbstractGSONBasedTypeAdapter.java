package com.coherentlogic.treasurydirect.client.core.adapters;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.coherent.data.adapter.core.factories.TypedFactory;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

/**
 * Adapter base class for converting JSON into objects in the domain model using the Google GSON API.
 *
 * @see <a href="https://github.com/google/gson">GSON</a>
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public abstract class AbstractGSONBasedTypeAdapter<T extends SerializableBean> extends TypeAdapter<T> {

    private final GsonBuilder gsonBuilder;

    private final TypedFactory<T> typedFactory;

    public AbstractGSONBasedTypeAdapter(TypedFactory<T> typedFactory) {
        this (new GsonBuilder(), typedFactory);
    }

    public AbstractGSONBasedTypeAdapter(GsonBuilder gsonBuilder, TypedFactory<T> typedFactory) {
        this.gsonBuilder = gsonBuilder;
        this.typedFactory = typedFactory;
    }

    public GsonBuilder getGsonBuilder() {
        return gsonBuilder;
    }

    public TypedFactory<T> getTypedFactory() {
        return typedFactory;
    }
}

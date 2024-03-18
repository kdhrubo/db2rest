package com.homihq.db2rest.mongodb.rsql.argconverters;

import com.homihq.db2rest.mongodb.rsql.structs.ConversionInfo;
import com.homihq.db2rest.mongodb.rsql.structs.Lazy;

public interface StringToQueryValueConverter {

    Lazy<Object> convert(ConversionInfo info);

}

package com.homihq.db2rest.rest.read.helper;

import com.homihq.db2rest.rsql.operators.SimpleRSQLOperators;
import com.homihq.db2rest.rsql.parser.MyBatisFilterVisitor;
import com.homihq.db2rest.schema.SchemaManager;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlCriterion;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class WhereBuilder{


    private final SchemaManager schemaManager;

    public void build(ReadContext context) {
        if(StringUtils.isNotBlank(context.filter)) {

            log.info("-Creating where condition -");

            Node rootNode = new RSQLParser(SimpleRSQLOperators.customOperators()).parse(context.filter);

            SqlCriterion condition = rootNode
                    .accept(new MyBatisFilterVisitor(context.from));

            context.addWhereClause(condition);

        }

    }
}

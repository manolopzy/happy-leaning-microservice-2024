package happylearning.arithmeticservice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArithmeticOperation is a Querydsl query type for ArithmeticOperation
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QArithmeticOperation extends BeanPath<ArithmeticOperation> {

    private static final long serialVersionUID = 2063051813L;

    public static final QArithmeticOperation arithmeticOperation = new QArithmeticOperation("arithmeticOperation");

    public final NumberPath<Integer> factorA = createNumber("factorA", Integer.class);

    public final NumberPath<Integer> factorB = createNumber("factorB", Integer.class);

    public final NumberPath<Byte> level = createNumber("level", Byte.class);

    public final StringPath operator = createString("operator");

    public final ListPath<String, StringPath> options = this.<String, StringPath>createList("options", String.class, StringPath.class, PathInits.DIRECT2);

    public QArithmeticOperation(String variable) {
        super(ArithmeticOperation.class, forVariable(variable));
    }

    public QArithmeticOperation(Path<ArithmeticOperation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArithmeticOperation(PathMetadata metadata) {
        super(ArithmeticOperation.class, metadata);
    }

}


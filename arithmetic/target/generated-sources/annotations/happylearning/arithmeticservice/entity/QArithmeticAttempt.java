package happylearning.arithmeticservice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArithmeticAttempt is a Querydsl query type for ArithmeticAttempt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArithmeticAttempt extends EntityPathBase<ArithmeticAttempt> {

    private static final long serialVersionUID = 1908424971L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArithmeticAttempt arithmeticAttempt = new QArithmeticAttempt("arithmeticAttempt");

    public final QArithmeticOperation arithmetic;

    public final BooleanPath correct = createBoolean("correct");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> result = createNumber("result", Integer.class);

    public final QUser user;

    public QArithmeticAttempt(String variable) {
        this(ArithmeticAttempt.class, forVariable(variable), INITS);
    }

    public QArithmeticAttempt(Path<? extends ArithmeticAttempt> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArithmeticAttempt(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArithmeticAttempt(PathMetadata metadata, PathInits inits) {
        this(ArithmeticAttempt.class, metadata, inits);
    }

    public QArithmeticAttempt(Class<? extends ArithmeticAttempt> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.arithmetic = inits.isInitialized("arithmetic") ? new QArithmeticOperation(forProperty("arithmetic")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}


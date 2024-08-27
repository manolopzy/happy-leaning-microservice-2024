package happylearning.arithmeticservice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUser extends BeanPath<User> {

    private static final long serialVersionUID = 813667459L;

    public static final QUser user = new QUser("user");

    public final StringPath alias = createString("alias");

    public final StringPath id = createString("id");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}


package happylearning.arithmeticservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@NoArgsConstructor
@AllArgsConstructor
@Data
public final class User {
	private String id;
	@NonNull
	private String alias;
	
}

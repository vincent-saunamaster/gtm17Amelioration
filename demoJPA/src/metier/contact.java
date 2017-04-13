package metier;

@Entity
public class contact {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private int id;
	private String nom;
	private String prenom;
	private String email;
}

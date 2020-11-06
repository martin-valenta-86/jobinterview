package cz.valenta.jobinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Napište program, který bude vystavovat REST službu, která na vstupu bude přijímat text.
 * Služba text transformuje a vrátí zpět. Transformaci provede tak,
 * že v textu otočí pořadí písmen (tedy přečte ho odzadu) s tím, že:
 * 	• na pozici, kde se původně vyskytovala písmena a,e,i,o,u budou nově písmena uppercase,
 * 		všechna ostatní písmena budou lowercase.
 * 	• Dvě a více mezer spojí do jedné mezery.
 */
@SpringBootApplication
public class JobinterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobinterviewApplication.class, args);
	}

}

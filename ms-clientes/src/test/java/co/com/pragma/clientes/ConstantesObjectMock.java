package co.com.pragma.clientes;

import com.pragma.clientes.dto.ClientesDto;
import com.pragma.clientes.dto.PhotosDto;
import com.pragma.clientes.model.Clientes;

public class ConstantesObjectMock {
	public static final ClientesDto CLIENTE_DTO_TEST=new ClientesDto(85L,"473128560","DNI","Miguel","CAMPOS123",29,"trujillo","1","1111111111111111333333333333785785675675675675CCCCCCCCCCD");
	public static final ClientesDto CLIENTE_DTO_TEST_NEW=new ClientesDto(null,"473128560","DNI","Miguel","CAMPOS123",29,"trujillo","1","1111111111111111333333333333785785675675675675CCCCCCCCCCD");
	public static final PhotosDto FOTO_DTO_TEST_DELETED=new PhotosDto(85L,"1111111111111111333333333333785785675675675675CCCCCCCCCCD",0);
	public static final Clientes CLIENTE_TEST_DELETED=new Clientes(85L,"473128560","DNI","Miguel","CAMPOS123",29,0,"trujillo");
	public static final ClientesDto CLIENTE_DTO_TEST_DELETED=new ClientesDto(85L,"473128560","DNI","Miguel","CAMPOS123",29,"trujillo","0",null);
	public static final Clientes CLIENTE_TEST_FOR_DELETED=new Clientes(85L,"473128560","DNI","Miguel","CAMPOS123",29,1,"trujillo");

	public static final ClientesDto CLIENTE_DTO_TEST_WITHOUT_IMAGE=new ClientesDto(85L,"473128560","DNI","Miguel","CAMPOS123",29,"trujillo","1",null);
	public static final Clientes CLIENTE_TEST=new Clientes(85L,"473128560","DNI","Miguel","CAMPOS123",29,1,"trujillo");
	public static final PhotosDto FOTO_DTO_TEST=new PhotosDto(85L,"1111111111111111333333333333785785675675675675CCCCCCCCCCD",1);
	public static final Clientes CLIENTE_TEST_NEW=new Clientes(null,"473128560","DNI","Miguel","CAMPOS123",29,1,"trujillo");
	public static final PhotosDto FOTO_DTO_TEST_NEW=new PhotosDto(null,"1111111111111111333333333333785785675675675675CCCCCCCCCCD",1);
	public static final String NUMERO_DOCUMENTO="473128560";
	public static final Long ID_CLIENTE=85L;
	public static final Integer EDAD_CLIENTE=20;
}

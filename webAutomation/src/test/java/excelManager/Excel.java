package excelManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private static final int ID = 0;
	private static final int IDTEST = 0;
	private static final int SITE = 1;
	private static final int PROTUDO = 2;
	private static final int EMAIL = 3;
	private static final int GENERO = 4;
	private static final int NOME = 5;
	private static final int SOBRENOME = 6;
	private static final int SENHA = 7;
	private static final int DATA_NASCIMENTO = 8;
	private static final int NOME_ENTREGA = 9;
	private static final int SOBRENOME_ENTREGA = 10;
	private static final int EMPRESA = 11;
	private static final int ENDERECO = 12;
	private static final int CIDADE = 13;
	private static final int ESTADO = 14;
	private static final int CODIGO_POSTAL = 15;
	private static final int PAIS = 16;
	private static final int INFORMACAO_ADICIONAL = 17;
	private static final int TELEFONE = 18;
	private static final int ENDEREÇO_REFERENCIA = 19;
	private static final int VALOR_TOTAL = 20;

	public TestData getTestData(String id) {

		String numberId = id.substring(0, 3);

		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		TestData massa = null;

		try {

			File planilha_massa = new File(getClass().getClassLoader().getResource("DataProvider.xlsx").getFile());
			file = new FileInputStream(planilha_massa);

			workbook = new XSSFWorkbook(file);
			XSSFSheet abaTeste = workbook.getSheet("Teste");

			Row linhaTesteAtual = linhaDeId(abaTeste, numberId);

			massa = new TestData();
			massa.setIdTest(linhaTesteAtual.getCell(IDTEST).getStringCellValue());
			massa.setSite(linhaTesteAtual.getCell(SITE).getStringCellValue());
			massa.setProduto(linhaTesteAtual.getCell(PROTUDO).getStringCellValue());
			massa.setEmail(linhaTesteAtual.getCell(EMAIL).getStringCellValue());
			massa.setGenero(linhaTesteAtual.getCell(GENERO).getStringCellValue());
			massa.setNome(linhaTesteAtual.getCell(NOME).getStringCellValue());
			massa.setSobrenome(linhaTesteAtual.getCell(SOBRENOME).getStringCellValue());
			massa.setSenha(linhaTesteAtual.getCell(SENHA).getStringCellValue());
			massa.setDataNascimento(linhaTesteAtual.getCell(DATA_NASCIMENTO).getDateCellValue());
			massa.setNomeEntrega(linhaTesteAtual.getCell(NOME_ENTREGA).getStringCellValue());
			massa.setSobrenomeEntrega(linhaTesteAtual.getCell(SOBRENOME_ENTREGA).getStringCellValue());
			massa.setEmpresa(linhaTesteAtual.getCell(EMPRESA).getStringCellValue());
			massa.setEndereco(linhaTesteAtual.getCell(ENDERECO).getStringCellValue());
			massa.setCidade(linhaTesteAtual.getCell(CIDADE).getStringCellValue());
			massa.setEstado(linhaTesteAtual.getCell(ESTADO).getStringCellValue());
			massa.setCodigoPostal(linhaTesteAtual.getCell(CODIGO_POSTAL).getStringCellValue());
			massa.setPais(linhaTesteAtual.getCell(PAIS).getStringCellValue());
			massa.setInformacaoAdicional(linhaTesteAtual.getCell(INFORMACAO_ADICIONAL).getStringCellValue());
			massa.setTelefone(linhaTesteAtual.getCell(TELEFONE).getStringCellValue());
			massa.setEndereçoReferencia(linhaTesteAtual.getCell(ENDEREÇO_REFERENCIA).getStringCellValue());
			massa.setValorTotal(linhaTesteAtual.getCell(VALOR_TOTAL).getStringCellValue());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return massa;

	}

	public static Row linhaDeId(XSSFSheet sheet, String itemPesquisar) {

		itemPesquisar = itemPesquisar.length() < 1 ? "null" : itemPesquisar;

		Row linhaEncontrada = sheet.getRow(0);

		for (Row row : sheet) {

			Cell cellID = row.getCell(ID);

			if (cellID.getStringCellValue().trim().equals(itemPesquisar)) {

				linhaEncontrada = row;
				break;

			}

		}

		return linhaEncontrada;

	}

}

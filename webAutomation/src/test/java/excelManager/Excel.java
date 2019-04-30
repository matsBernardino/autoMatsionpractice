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

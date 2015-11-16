package de.leanovate.swaggercheck.schema

import de.leanovate.swaggercheck.SwaggerChecks
import de.leanovate.swaggercheck.schema.model.{ArrayDefinition, JsonPath}
import de.leanovate.swaggercheck.shrinkable._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{MustMatchers, WordSpec}

class ArrayDefinitionSpec extends WordSpec with MustMatchers with MockitoSugar {
  "ArrayDefinition" should {
    "fail verify for non array nodes" in {
      val mockContext = mock[SwaggerChecks]
      val arrayDefinition = ArrayDefinition(None, None, None)

      arrayDefinition.validate[CheckJsValue](mockContext, JsonPath(), CheckJsBoolean(false)).isSuccess mustBe false
      arrayDefinition.validate[CheckJsValue](mockContext, JsonPath(), CheckJsObject.empty).isSuccess mustBe false
      arrayDefinition.validate[CheckJsValue](mockContext, JsonPath(), CheckJsInteger(None, None, 0)).isSuccess mustBe false
      arrayDefinition.validate[CheckJsValue](mockContext, JsonPath(), CheckJsString.unformatted("")).isSuccess mustBe false
    }
  }

}
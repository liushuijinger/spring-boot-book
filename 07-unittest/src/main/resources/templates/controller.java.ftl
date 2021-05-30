package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @blog https://liushuijinger.blog.csdn.net
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if swagger2>
@Api(value = "${entity}对象",tags = "${table.comment!}")
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};


    @ApiOperation(value = "查询")
    @GetMapping(value = "/{id}")
    public ${entity} get(@PathVariable Integer id) {
      return ${table.serviceName?uncap_first}.getById(id);
    }

    @ApiOperation(value = "新增")
    @PostMapping
    public Boolean add(@RequestBody ${entity} ${entity?uncap_first}) {
      return ${table.serviceName?uncap_first}.save(${entity?uncap_first});
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public Boolean modify(@RequestBody ${entity} ${entity?uncap_first}) {
      return ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable Integer id) {
      return ${table.serviceName?uncap_first}.removeById(id);
    }
}
</#if>

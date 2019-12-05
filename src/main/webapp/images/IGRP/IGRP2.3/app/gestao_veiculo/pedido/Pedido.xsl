<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"><xsl:output method="html" omit-xml-declaration="yes" encoding="utf-8" indent="yes" doctype-system="about:legacy-compat"/><xsl:template match="/"><html><head><xsl:call-template name="IGRP-head"/><style/></head><body class="{$bodyClass} sidebar-off"><xsl:call-template name="IGRP-topmenu"/><form method="POST" class="IGRP-form" name="formular_default" enctype="multipart/form-data"><div class="container-fluid"><div class="row"><xsl:call-template name="IGRP-sidebar"/><div class="col-sm-9 col-md-10 col-md-offset-2 col-sm-offset-3 main" id="igrp-contents"><div class="content"><div class="row row-msg"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:apply-templates mode="igrp-messages" select="rows/content/messages"/></div></div></div><div class="row " id="row-ca083974"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:if test="rows/content/form_pedido"><div class="box igrp-forms gen-container-item " gen-class="" item-name="form_pedido"><div class="box-body"><div role="form"><xsl:apply-templates mode="form-hidden-fields" select="rows/content/form_pedido/fields"/><xsl:if test="rows/content/form_pedido/fields/nome"><div class="form-group col-sm-3   gen-fields-holder" item-name="nome" item-type="text"><label for="{rows/content/form_pedido/fields/nome/@name}"><span><xsl:value-of select="rows/content/form_pedido/fields/nome/label"/></span></label><input type="text" value="{rows/content/form_pedido/fields/nome/value}" class="form-control  " id="{rows/content/form_pedido/fields/nome/@name}" name="{rows/content/form_pedido/fields/nome/@name}" maxlength="250" placeholder="{rows/content/form_pedido/fields/nome/@placeholder}"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_pedido/fields/nome"/></xsl:call-template></input></div></xsl:if><xsl:if test="rows/content/form_pedido/fields/obs_pedido"><div class="form-group col-sm-3   gen-fields-holder" item-name="obs_pedido" item-type="text"><label for="{rows/content/form_pedido/fields/obs_pedido/@name}"><span><xsl:value-of select="rows/content/form_pedido/fields/obs_pedido/label"/></span></label><input type="text" value="{rows/content/form_pedido/fields/obs_pedido/value}" class="form-control  " id="{rows/content/form_pedido/fields/obs_pedido/@name}" name="{rows/content/form_pedido/fields/obs_pedido/@name}" maxlength="250" placeholder="{rows/content/form_pedido/fields/obs_pedido/@placeholder}"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_pedido/fields/obs_pedido"/></xsl:call-template></input></div></xsl:if></div></div><xsl:apply-templates select="rows/content/form_pedido/tools-bar" mode="form-buttons"/></div></xsl:if></div></div></div></div></div></div></div><xsl:call-template name="IGRP-bottom"/></form><script type="text/javascript" src="{$path}/core/igrp/form/igrp.forms.js?v={$version}"/></body></html></xsl:template><xsl:include href="../../../xsl/tmpl/IGRP-functions.tmpl.xsl?v=26"/><xsl:include href="../../../xsl/tmpl/IGRP-variables.tmpl.xsl?v=26"/><xsl:include href="../../../xsl/tmpl/IGRP-home-include.tmpl.xsl?v=26"/><xsl:include href="../../../xsl/tmpl/IGRP-utils.tmpl.xsl?v=26"/><xsl:include href="../../../xsl/tmpl/IGRP-form-utils.tmpl.xsl?v=26"/></xsl:stylesheet>

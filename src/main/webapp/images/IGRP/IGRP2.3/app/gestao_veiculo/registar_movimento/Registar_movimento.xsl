<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"><xsl:output method="html" omit-xml-declaration="yes" encoding="utf-8" indent="yes" doctype-system="about:legacy-compat"/><xsl:template match="/"><html><head><xsl:call-template name="IGRP-head"/><link rel="stylesheet" type="text/css" href="{$path}/core/igrp/toolsbar/toolsbar.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/plugins/select2/select2.min.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/plugins/select2/select2.style.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/plugins/datepicker2/daterangepicker.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/plugins/datepicker2/IGRP.daterangepicker.css?v={$version}"/><link rel="stylesheet" type="text/css" href="{$path}/plugins/datetimepicker/css/datetimepicker.css?v={$version}"/><style/></head><body class="{$bodyClass} sidebar-off"><xsl:call-template name="IGRP-topmenu"/><form method="POST" class="IGRP-form" name="formular_default" enctype="multipart/form-data"><div class="container-fluid"><div class="row"><xsl:call-template name="IGRP-sidebar"/><div class="col-sm-9 col-md-10 col-md-offset-2 col-sm-offset-3 main" id="igrp-contents"><div class="content"><div class="row row-msg"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:apply-templates mode="igrp-messages" select="rows/content/messages"/></div></div></div><div class="row " id="row-84797dcb"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:if test="rows/content/header"><section class="content-header gen-container-item " gen-class="" item-name="header"><h2 class="disable-output-escaping"><xsl:value-of disable-output-escaping="yes" select="rows/content/header/fields/header_text/value"/></h2></section></xsl:if><xsl:if test="rows/content/toolsbar_1"><div class="toolsbar-holder default gen-container-item " gen-structure="toolsbar" gen-fields=".btns-holder&gt;a.btn" gen-class="" item-name="toolsbar_1"><div class="btns-holder   pull-right" role="group"><xsl:apply-templates select="rows/content/toolsbar_1" mode="gen-buttons"><xsl:with-param name="vertical" select="'true'"/><xsl:with-param name="outline" select="'false'"/></xsl:apply-templates></div></div></xsl:if><xsl:if test="rows/content/form_mov"><div class="box igrp-forms gen-container-item " gen-class="" item-name="form_mov"><xsl:call-template name="box-header"><xsl:with-param name="title" select="rows/content/form_mov/@title"/><xsl:with-param name="collapsible" select="'true'"/><xsl:with-param name="collapsed" select="'false'"/></xsl:call-template><div class="box-body"><div role="form"><xsl:apply-templates mode="form-hidden-fields" select="rows/content/form_mov/fields"/><xsl:if test="rows/content/form_mov/fields/condutor"><div class="form-group col-sm-3  gen-fields-holder" item-name="condutor" item-type="lookup" required="required"><label for="{rows/content/form_mov/fields/condutor/@name}"><xsl:value-of select="rows/content/form_mov/fields/condutor/label"/></label><div class="input-group"><input type="text" value="{rows/content/form_mov/fields/condutor/value}" class="form-control gen-lookup " id="form_mov_condutor" name="{rows/content/form_mov/fields/condutor/@name}" required="required" readonly="readonly" maxlength="250"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_mov/fields/condutor"/></xsl:call-template></input><xsl:call-template name="lookup-tool"><xsl:with-param name="page" select="rows/page"/><xsl:with-param name="ad_hoc" select="'1'"/><xsl:with-param name="action" select="'LOOKUP'"/><xsl:with-param name="name" select="rows/content/form_mov/fields/condutor/@name"/><xsl:with-param name="js_lookup" select="rows/content/form_mov/fields/condutor/lookup"/><xsl:with-param name="input-id" select="'form_mov_condutor'"/><xsl:with-param name="btnClass" select="'info'"/></xsl:call-template></div></div></xsl:if><xsl:if test="rows/content/form_mov/fields/veiculo"><div class="col-sm-3 form-group  gen-fields-holder" item-name="veiculo" item-type="select" required="required"><label for="{rows/content/form_mov/fields/veiculo/@name}"><xsl:value-of select="rows/content/form_mov/fields/veiculo/label"/></label><select class="form-control select2 " id="form_mov_veiculo" name="{rows/content/form_mov/fields/veiculo/@name}" required="required"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_mov/fields/veiculo"/></xsl:call-template><xsl:for-each select="rows/content/form_mov/fields/veiculo/list/option"><option value="{value}" label="{text}"><xsl:if test="@selected='true'"><xsl:attribute name="selected">selected</xsl:attribute></xsl:if><span><xsl:value-of select="text"/></span></option></xsl:for-each></select></div></xsl:if><xsl:if test="rows/content/form_mov/fields/data_saida"><div class="form-group col-sm-3  gen-date-picker-wrapper gen-fields-holder" item-name="data_saida" item-type="date" required="required"><label for="{rows/content/form_mov/fields/data_saida/@name}"><span><xsl:value-of select="rows/content/form_mov/fields/data_saida/label"/></span></label><div class="input-group"><input type="text" value="{rows/content/form_mov/fields/data_saida/value}" data-range="false" class="form-control gen-date-picker " id="data_saida" name="{rows/content/form_mov/fields/data_saida/@name}" required="required" format="" maxlength="250" placeholder=""><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_mov/fields/data_saida"/></xsl:call-template></input><span class="datepicker-clear fa fa-times"/><span class="input-group-btn gen-date-icon"><a class="btn btn-info"><i class="fa fa-calendar"/></a></span></div></div></xsl:if><xsl:if test="rows/content/form_mov/fields/hora"><div class="form-group col-sm-3  gen-fields-holder" item-name="hora" item-type="time" required="required"><label for="{rows/content/form_mov/fields/hora/@name}"><span><xsl:value-of select="rows/content/form_mov/fields/hora/label"/></span></label><input type="time" value="{rows/content/form_mov/fields/hora/value}" class="form-control gen-date " id="form_mov-hora" name="{rows/content/form_mov/fields/hora/@name}" required="required" format="" maxlength="250"><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_mov/fields/hora"/></xsl:call-template></input></div></xsl:if><xsl:if test="rows/content/form_mov/fields/km_saida"><div class="form-group col-sm-3   gen-fields-holder" item-name="km_saida" item-type="number" required="required"><label for="{rows/content/form_mov/fields/km_saida/@name}"><span><xsl:value-of select="rows/content/form_mov/fields/km_saida/label"/></span></label><input type="number" value="{rows/content/form_mov/fields/km_saida/value}" min="" max="" class="form-control  " id="{rows/content/form_mov/fields/km_saida/@name}" name="{rows/content/form_mov/fields/km_saida/@name}" required="required" maxlength="250" placeholder=""><xsl:call-template name="setAttributes"><xsl:with-param name="field" select="rows/content/form_mov/fields/km_saida"/></xsl:call-template></input></div></xsl:if></div></div><xsl:apply-templates select="rows/content/form_mov/tools-bar" mode="form-buttons"/></div></xsl:if></div></div></div></div></div></div></div><xsl:call-template name="IGRP-bottom"/></form><script type="text/javascript" src="{$path}/core/igrp/form/igrp.forms.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/lookup/igrp.lookup.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/select2/select2.full.min.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/select2/select2.init.js?v={$version}"/><script type="text/javascript" src="{$path}/core/moment/moment.min.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/datepicker2/daterangepicker.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/datepicker2/IGRP.daterangepicker.config.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/datepicker2/locale/dp.locale.pt.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/datetimepicker/js/datetimepicker.js?v={$version}"/><script type="text/javascript" src="{$path}/plugins/datetimepicker/js/dtp.init.js?v={$version}"/></body></html></xsl:template><xsl:include href="../../../xsl/tmpl/IGRP-functions.tmpl.xsl?v=20"/><xsl:include href="../../../xsl/tmpl/IGRP-variables.tmpl.xsl?v=20"/><xsl:include href="../../../xsl/tmpl/IGRP-home-include.tmpl.xsl?v=20"/><xsl:include href="../../../xsl/tmpl/IGRP-utils.tmpl.xsl?v=20"/><xsl:include href="../../../xsl/tmpl/IGRP-form-utils.tmpl.xsl?v=20"/></xsl:stylesheet>
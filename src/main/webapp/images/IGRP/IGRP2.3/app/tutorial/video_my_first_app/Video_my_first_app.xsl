<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"><xsl:output method="html" omit-xml-declaration="yes" encoding="utf-8" indent="yes" doctype-system="about:legacy-compat"/><xsl:template match="/"><html><head><xsl:call-template name="IGRP-head"/><style/></head><body class="{$bodyClass} sidebar-off"><xsl:call-template name="IGRP-topmenu"/><form method="POST" class="IGRP-form" name="formular_default" enctype="multipart/form-data"><div class="container-fluid"><div class="row"><xsl:call-template name="IGRP-sidebar"/><div class="col-sm-9 col-md-10 col-md-offset-2 col-sm-offset-3 main" id="igrp-contents"><div class="content"><div class="row row-msg"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:apply-templates mode="igrp-messages" select="rows/content/messages"/></div></div></div><div class="row " id="row-cca738a2"><div class="gen-column col-md-12"><div class="gen-inner"><xsl:if test="rows/content/paragraph_1"><div class="box gen-container-item " gen-class="" item-name="paragraph_1"><xsl:call-template name="box-header"><xsl:with-param name="title" select="rows/content/paragraph_1/@title"/><xsl:with-param name="collapsible" select="'true'"/><xsl:with-param name="collapsed" select="'false'"/></xsl:call-template><div class="box-body"><p><xsl:value-of select="rows/content/paragraph_1/fields/paragraph_1_text/value"/></p></div></div></xsl:if><xsl:if test="rows/content/video_1"><div class="gen-container-item " gen-class="" item-name="video_1"><xsl:call-template name="box-header"><xsl:with-param name="title" select="rows/content/video_1/@title"/><xsl:with-param name="collapsible" select="'false'"/><xsl:with-param name="collapsed" select="'false'"/></xsl:call-template><div class="box-body"><iframe style="height:500px" src="{rows/content/video_1/fields/video_1_text/value}" frameborder="0" allowfullscreen=""/></div></div></xsl:if></div></div></div></div></div></div></div><xsl:call-template name="IGRP-bottom"/></form></body></html></xsl:template><xsl:include href="../../../xsl/tmpl/IGRP-functions.tmpl.xsl?v=1528810373787"/><xsl:include href="../../../xsl/tmpl/IGRP-variables.tmpl.xsl?v=1528810373787"/><xsl:include href="../../../xsl/tmpl/IGRP-home-include.tmpl.xsl?v=1528810373787"/><xsl:include href="../../../xsl/tmpl/IGRP-utils.tmpl.xsl?v=1528810373787"/></xsl:stylesheet>

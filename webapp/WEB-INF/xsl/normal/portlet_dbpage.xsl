<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="portlet">
	
	<xsl:variable name="device_class">
	<xsl:choose>
		<xsl:when test="string(display-on-small-device)='0'">hidden-phone</xsl:when>
		<xsl:otherwise></xsl:otherwise>
	</xsl:choose>
	</xsl:variable>
		<div class="portlet  {$device_class} append-bottom -lutece-border-radius">
			<xsl:choose>
				<xsl:when test="not(string(display-portlet-title)='1')">
					<h3 class="portlet-header ">
						<xsl:value-of disable-output-escaping="yes" select="portlet-name" />
					</h3>
					<div class="portlet-content">
						<xsl:apply-templates select="dbpage-portlet" />
					</div>
				</xsl:when>
				<xsl:otherwise>
					<div class="portlet-content">
						<xsl:apply-templates select="dbpage-portlet" />
					</div>
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>


	<xsl:template match="dbpage-portlet">
		<xsl:apply-templates select="dbpage-portlet-content" />
	</xsl:template>


	<xsl:template match="dbpage-portlet-content">
		<xsl:value-of disable-output-escaping="yes" select="." />

	</xsl:template>


</xsl:stylesheet>

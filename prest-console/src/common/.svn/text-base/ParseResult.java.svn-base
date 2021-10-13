/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.List;

import common.data.DataContext;
import common.data.DataSet;

import parser.enumeration.Language;

/**
 * 
 * @author Gürhan
 */
public class ParseResult {

    private Language parserLanguage;
    private ParseMetricGroups parseMetricGroups;
    private ParseDataSets parseDataSets;

    public ParseResult() {
    }

    public ParseResult(Language language, DataContext collectedMetrics) {
        if (language != null && collectedMetrics != null) {
            parserLanguage = language;
            parseMetricGroups = null;
            parseDataSets = null;
            parseMetricGroups = new ParseMetricGroups(collectedMetrics);
            
            if (parserLanguage == parser.enumeration.Language.PLSQL) {
				//if language is PLSQL then replace package and file metrics
				replace(parseMetricGroups);
			}
			collectedMetrics = null;
            parseDataSets = new ParseDataSets(parseMetricGroups);
            parseMetricGroups = null;
        }
    }

    private void replace(ParseMetricGroups parseMetricGroups2) {
    	List<MetricGroup> tempGroup = parseMetricGroups2.getFileMetrics();
    	parseMetricGroups2.setFileMetrics(parseMetricGroups2.getPackageMetrics());
    	parseMetricGroups2.setPackageMetrics(tempGroup);
		
	}

	public ParseDataSets getParseDataSets() {
        return this.parseDataSets;
    }

    public void setDataSetByMetricType(int metricType, DataSet ds) {
        this.parseDataSets.setByMetricTypes(metricType, ds);
    }

    public void setParseDataSets(ParseDataSets parseDataSets) {
        this.parseDataSets = parseDataSets;
    }

    public ParseMetricGroups getParseMetricGroups() {
        return this.parseMetricGroups;
    }

    public void setParseMetricGroups(ParseMetricGroups parseMetricGroups) {
        this.parseMetricGroups = parseMetricGroups;
    }

    public Language getParserLanguage() {
        return this.parserLanguage;
    }

    public void setParserLanguage(Language parserLanguage) {
        this.parserLanguage = parserLanguage;
    }

    public DataSet getDataSetByMetricType(int metricType) {
        return this.parseDataSets.getByMetricType(metricType);
    }
}

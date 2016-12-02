package cn.com.cloudinsight.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FlatTable implements Serializable {
    private Integer id;

    private Date time;

    private String name;

    private String specification;

    private BigDecimal coremark;

    private BigDecimal scimark1Composite;

    private BigDecimal scimark2Composite;

    private BigDecimal scimark3Composite;

    private BigDecimal scimark4Composite;

    private BigDecimal hpccRandom100;

    private BigDecimal hpccCopy;

    private BigDecimal hpccScale;

    private BigDecimal hpccAdd;

    private BigDecimal hpccTriad;

    private BigDecimal pingMin;

    private BigDecimal pingAverage;

    private BigDecimal pingMax;

    private BigDecimal pingStd;

    private BigDecimal iperfInternal;

    private BigDecimal iperfExternal;

    private BigDecimal netperfTcpRrInternal;

    private BigDecimal netperfTcpCrrInternal;

    private BigDecimal netperfTcpStreamInternal;

    private BigDecimal netperfUdpRrInternal;

    private BigDecimal fioSequentialWriteBandwidth;

    private BigDecimal fioSequentialReadBandwidth;

    private BigDecimal fioRandomWriteBandwidth;

    private BigDecimal fioRandomReadBandwidth;

    private BigDecimal fioSequentialWriteLatency;

    private BigDecimal fioSequentialReadLatency;

    private BigDecimal fioRandomWriteLatency;

    private BigDecimal fioRandomReadLatency;

    private BigDecimal fioSequentialWriteIops;

    private BigDecimal fioSequentialReadIops;

    private BigDecimal fioRandomWriteIops;

    private BigDecimal fioRandomReadIops;

    private BigDecimal unixbenchIndex;

    private BigDecimal sysbenchOltp;

    private BigDecimal ycsbThroughputA;

    private BigDecimal ycsbThroughputB;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public BigDecimal getCoremark() {
        return coremark;
    }

    public void setCoremark(BigDecimal coremark) {
        this.coremark = coremark;
    }

    public BigDecimal getScimark1Composite() {
        return scimark1Composite;
    }

    public void setScimark1Composite(BigDecimal scimark1Composite) {
        this.scimark1Composite = scimark1Composite;
    }

    public BigDecimal getScimark2Composite() {
        return scimark2Composite;
    }

    public void setScimark2Composite(BigDecimal scimark2Composite) {
        this.scimark2Composite = scimark2Composite;
    }

    public BigDecimal getScimark3Composite() {
        return scimark3Composite;
    }

    public void setScimark3Composite(BigDecimal scimark3Composite) {
        this.scimark3Composite = scimark3Composite;
    }

    public BigDecimal getScimark4Composite() {
        return scimark4Composite;
    }

    public void setScimark4Composite(BigDecimal scimark4Composite) {
        this.scimark4Composite = scimark4Composite;
    }

    public BigDecimal getHpccRandom100() {
        return hpccRandom100;
    }

    public void setHpccRandom100(BigDecimal hpccRandom100) {
        this.hpccRandom100 = hpccRandom100;
    }

    public BigDecimal getHpccCopy() {
        return hpccCopy;
    }

    public void setHpccCopy(BigDecimal hpccCopy) {
        this.hpccCopy = hpccCopy;
    }

    public BigDecimal getHpccScale() {
        return hpccScale;
    }

    public void setHpccScale(BigDecimal hpccScale) {
        this.hpccScale = hpccScale;
    }

    public BigDecimal getHpccAdd() {
        return hpccAdd;
    }

    public void setHpccAdd(BigDecimal hpccAdd) {
        this.hpccAdd = hpccAdd;
    }

    public BigDecimal getHpccTriad() {
        return hpccTriad;
    }

    public void setHpccTriad(BigDecimal hpccTriad) {
        this.hpccTriad = hpccTriad;
    }

    public BigDecimal getPingMin() {
        return pingMin;
    }

    public void setPingMin(BigDecimal pingMin) {
        this.pingMin = pingMin;
    }

    public BigDecimal getPingAverage() {
        return pingAverage;
    }

    public void setPingAverage(BigDecimal pingAverage) {
        this.pingAverage = pingAverage;
    }

    public BigDecimal getPingMax() {
        return pingMax;
    }

    public void setPingMax(BigDecimal pingMax) {
        this.pingMax = pingMax;
    }

    public BigDecimal getPingStd() {
        return pingStd;
    }

    public void setPingStd(BigDecimal pingStd) {
        this.pingStd = pingStd;
    }

    public BigDecimal getIperfInternal() {
        return iperfInternal;
    }

    public void setIperfInternal(BigDecimal iperfInternal) {
        this.iperfInternal = iperfInternal;
    }

    public BigDecimal getIperfExternal() {
        return iperfExternal;
    }

    public void setIperfExternal(BigDecimal iperfExternal) {
        this.iperfExternal = iperfExternal;
    }

    public BigDecimal getNetperfTcpRrInternal() {
        return netperfTcpRrInternal;
    }

    public void setNetperfTcpRrInternal(BigDecimal netperfTcpRrInternal) {
        this.netperfTcpRrInternal = netperfTcpRrInternal;
    }

    public BigDecimal getNetperfTcpCrrInternal() {
        return netperfTcpCrrInternal;
    }

    public void setNetperfTcpCrrInternal(BigDecimal netperfTcpCrrInternal) {
        this.netperfTcpCrrInternal = netperfTcpCrrInternal;
    }

    public BigDecimal getNetperfTcpStreamInternal() {
        return netperfTcpStreamInternal;
    }

    public void setNetperfTcpStreamInternal(BigDecimal netperfTcpStreamInternal) {
        this.netperfTcpStreamInternal = netperfTcpStreamInternal;
    }

    public BigDecimal getNetperfUdpRrInternal() {
        return netperfUdpRrInternal;
    }

    public void setNetperfUdpRrInternal(BigDecimal netperfUdpRrInternal) {
        this.netperfUdpRrInternal = netperfUdpRrInternal;
    }

    public BigDecimal getFioSequentialWriteBandwidth() {
        return fioSequentialWriteBandwidth;
    }

    public void setFioSequentialWriteBandwidth(BigDecimal fioSequentialWriteBandwidth) {
        this.fioSequentialWriteBandwidth = fioSequentialWriteBandwidth;
    }

    public BigDecimal getFioSequentialReadBandwidth() {
        return fioSequentialReadBandwidth;
    }

    public void setFioSequentialReadBandwidth(BigDecimal fioSequentialReadBandwidth) {
        this.fioSequentialReadBandwidth = fioSequentialReadBandwidth;
    }

    public BigDecimal getFioRandomWriteBandwidth() {
        return fioRandomWriteBandwidth;
    }

    public void setFioRandomWriteBandwidth(BigDecimal fioRandomWriteBandwidth) {
        this.fioRandomWriteBandwidth = fioRandomWriteBandwidth;
    }

    public BigDecimal getFioRandomReadBandwidth() {
        return fioRandomReadBandwidth;
    }

    public void setFioRandomReadBandwidth(BigDecimal fioRandomReadBandwidth) {
        this.fioRandomReadBandwidth = fioRandomReadBandwidth;
    }

    public BigDecimal getFioSequentialWriteLatency() {
        return fioSequentialWriteLatency;
    }

    public void setFioSequentialWriteLatency(BigDecimal fioSequentialWriteLatency) {
        this.fioSequentialWriteLatency = fioSequentialWriteLatency;
    }

    public BigDecimal getFioSequentialReadLatency() {
        return fioSequentialReadLatency;
    }

    public void setFioSequentialReadLatency(BigDecimal fioSequentialReadLatency) {
        this.fioSequentialReadLatency = fioSequentialReadLatency;
    }

    public BigDecimal getFioRandomWriteLatency() {
        return fioRandomWriteLatency;
    }

    public void setFioRandomWriteLatency(BigDecimal fioRandomWriteLatency) {
        this.fioRandomWriteLatency = fioRandomWriteLatency;
    }

    public BigDecimal getFioRandomReadLatency() {
        return fioRandomReadLatency;
    }

    public void setFioRandomReadLatency(BigDecimal fioRandomReadLatency) {
        this.fioRandomReadLatency = fioRandomReadLatency;
    }

    public BigDecimal getFioSequentialWriteIops() {
        return fioSequentialWriteIops;
    }

    public void setFioSequentialWriteIops(BigDecimal fioSequentialWriteIops) {
        this.fioSequentialWriteIops = fioSequentialWriteIops;
    }

    public BigDecimal getFioSequentialReadIops() {
        return fioSequentialReadIops;
    }

    public void setFioSequentialReadIops(BigDecimal fioSequentialReadIops) {
        this.fioSequentialReadIops = fioSequentialReadIops;
    }

    public BigDecimal getFioRandomWriteIops() {
        return fioRandomWriteIops;
    }

    public void setFioRandomWriteIops(BigDecimal fioRandomWriteIops) {
        this.fioRandomWriteIops = fioRandomWriteIops;
    }

    public BigDecimal getFioRandomReadIops() {
        return fioRandomReadIops;
    }

    public void setFioRandomReadIops(BigDecimal fioRandomReadIops) {
        this.fioRandomReadIops = fioRandomReadIops;
    }

    public BigDecimal getUnixbenchIndex() {
        return unixbenchIndex;
    }

    public void setUnixbenchIndex(BigDecimal unixbenchIndex) {
        this.unixbenchIndex = unixbenchIndex;
    }

    public BigDecimal getSysbenchOltp() {
        return sysbenchOltp;
    }

    public void setSysbenchOltp(BigDecimal sysbenchOltp) {
        this.sysbenchOltp = sysbenchOltp;
    }

    public BigDecimal getYcsbThroughputA() {
        return ycsbThroughputA;
    }

    public void setYcsbThroughputA(BigDecimal ycsbThroughputA) {
        this.ycsbThroughputA = ycsbThroughputA;
    }

    public BigDecimal getYcsbThroughputB() {
        return ycsbThroughputB;
    }

    public void setYcsbThroughputB(BigDecimal ycsbThroughputB) {
        this.ycsbThroughputB = ycsbThroughputB;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FlatTable other = (FlatTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getCoremark() == null ? other.getCoremark() == null : this.getCoremark().equals(other.getCoremark()))
            && (this.getScimark1Composite() == null ? other.getScimark1Composite() == null : this.getScimark1Composite().equals(other.getScimark1Composite()))
            && (this.getScimark2Composite() == null ? other.getScimark2Composite() == null : this.getScimark2Composite().equals(other.getScimark2Composite()))
            && (this.getScimark3Composite() == null ? other.getScimark3Composite() == null : this.getScimark3Composite().equals(other.getScimark3Composite()))
            && (this.getScimark4Composite() == null ? other.getScimark4Composite() == null : this.getScimark4Composite().equals(other.getScimark4Composite()))
            && (this.getHpccRandom100() == null ? other.getHpccRandom100() == null : this.getHpccRandom100().equals(other.getHpccRandom100()))
            && (this.getHpccCopy() == null ? other.getHpccCopy() == null : this.getHpccCopy().equals(other.getHpccCopy()))
            && (this.getHpccScale() == null ? other.getHpccScale() == null : this.getHpccScale().equals(other.getHpccScale()))
            && (this.getHpccAdd() == null ? other.getHpccAdd() == null : this.getHpccAdd().equals(other.getHpccAdd()))
            && (this.getHpccTriad() == null ? other.getHpccTriad() == null : this.getHpccTriad().equals(other.getHpccTriad()))
            && (this.getPingMin() == null ? other.getPingMin() == null : this.getPingMin().equals(other.getPingMin()))
            && (this.getPingAverage() == null ? other.getPingAverage() == null : this.getPingAverage().equals(other.getPingAverage()))
            && (this.getPingMax() == null ? other.getPingMax() == null : this.getPingMax().equals(other.getPingMax()))
            && (this.getPingStd() == null ? other.getPingStd() == null : this.getPingStd().equals(other.getPingStd()))
            && (this.getIperfInternal() == null ? other.getIperfInternal() == null : this.getIperfInternal().equals(other.getIperfInternal()))
            && (this.getIperfExternal() == null ? other.getIperfExternal() == null : this.getIperfExternal().equals(other.getIperfExternal()))
            && (this.getNetperfTcpRrInternal() == null ? other.getNetperfTcpRrInternal() == null : this.getNetperfTcpRrInternal().equals(other.getNetperfTcpRrInternal()))
            && (this.getNetperfTcpCrrInternal() == null ? other.getNetperfTcpCrrInternal() == null : this.getNetperfTcpCrrInternal().equals(other.getNetperfTcpCrrInternal()))
            && (this.getNetperfTcpStreamInternal() == null ? other.getNetperfTcpStreamInternal() == null : this.getNetperfTcpStreamInternal().equals(other.getNetperfTcpStreamInternal()))
            && (this.getNetperfUdpRrInternal() == null ? other.getNetperfUdpRrInternal() == null : this.getNetperfUdpRrInternal().equals(other.getNetperfUdpRrInternal()))
            && (this.getFioSequentialWriteBandwidth() == null ? other.getFioSequentialWriteBandwidth() == null : this.getFioSequentialWriteBandwidth().equals(other.getFioSequentialWriteBandwidth()))
            && (this.getFioSequentialReadBandwidth() == null ? other.getFioSequentialReadBandwidth() == null : this.getFioSequentialReadBandwidth().equals(other.getFioSequentialReadBandwidth()))
            && (this.getFioRandomWriteBandwidth() == null ? other.getFioRandomWriteBandwidth() == null : this.getFioRandomWriteBandwidth().equals(other.getFioRandomWriteBandwidth()))
            && (this.getFioRandomReadBandwidth() == null ? other.getFioRandomReadBandwidth() == null : this.getFioRandomReadBandwidth().equals(other.getFioRandomReadBandwidth()))
            && (this.getFioSequentialWriteLatency() == null ? other.getFioSequentialWriteLatency() == null : this.getFioSequentialWriteLatency().equals(other.getFioSequentialWriteLatency()))
            && (this.getFioSequentialReadLatency() == null ? other.getFioSequentialReadLatency() == null : this.getFioSequentialReadLatency().equals(other.getFioSequentialReadLatency()))
            && (this.getFioRandomWriteLatency() == null ? other.getFioRandomWriteLatency() == null : this.getFioRandomWriteLatency().equals(other.getFioRandomWriteLatency()))
            && (this.getFioRandomReadLatency() == null ? other.getFioRandomReadLatency() == null : this.getFioRandomReadLatency().equals(other.getFioRandomReadLatency()))
            && (this.getFioSequentialWriteIops() == null ? other.getFioSequentialWriteIops() == null : this.getFioSequentialWriteIops().equals(other.getFioSequentialWriteIops()))
            && (this.getFioSequentialReadIops() == null ? other.getFioSequentialReadIops() == null : this.getFioSequentialReadIops().equals(other.getFioSequentialReadIops()))
            && (this.getFioRandomWriteIops() == null ? other.getFioRandomWriteIops() == null : this.getFioRandomWriteIops().equals(other.getFioRandomWriteIops()))
            && (this.getFioRandomReadIops() == null ? other.getFioRandomReadIops() == null : this.getFioRandomReadIops().equals(other.getFioRandomReadIops()))
            && (this.getUnixbenchIndex() == null ? other.getUnixbenchIndex() == null : this.getUnixbenchIndex().equals(other.getUnixbenchIndex()))
            && (this.getSysbenchOltp() == null ? other.getSysbenchOltp() == null : this.getSysbenchOltp().equals(other.getSysbenchOltp()))
            && (this.getYcsbThroughputA() == null ? other.getYcsbThroughputA() == null : this.getYcsbThroughputA().equals(other.getYcsbThroughputA()))
            && (this.getYcsbThroughputB() == null ? other.getYcsbThroughputB() == null : this.getYcsbThroughputB().equals(other.getYcsbThroughputB()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getCoremark() == null) ? 0 : getCoremark().hashCode());
        result = prime * result + ((getScimark1Composite() == null) ? 0 : getScimark1Composite().hashCode());
        result = prime * result + ((getScimark2Composite() == null) ? 0 : getScimark2Composite().hashCode());
        result = prime * result + ((getScimark3Composite() == null) ? 0 : getScimark3Composite().hashCode());
        result = prime * result + ((getScimark4Composite() == null) ? 0 : getScimark4Composite().hashCode());
        result = prime * result + ((getHpccRandom100() == null) ? 0 : getHpccRandom100().hashCode());
        result = prime * result + ((getHpccCopy() == null) ? 0 : getHpccCopy().hashCode());
        result = prime * result + ((getHpccScale() == null) ? 0 : getHpccScale().hashCode());
        result = prime * result + ((getHpccAdd() == null) ? 0 : getHpccAdd().hashCode());
        result = prime * result + ((getHpccTriad() == null) ? 0 : getHpccTriad().hashCode());
        result = prime * result + ((getPingMin() == null) ? 0 : getPingMin().hashCode());
        result = prime * result + ((getPingAverage() == null) ? 0 : getPingAverage().hashCode());
        result = prime * result + ((getPingMax() == null) ? 0 : getPingMax().hashCode());
        result = prime * result + ((getPingStd() == null) ? 0 : getPingStd().hashCode());
        result = prime * result + ((getIperfInternal() == null) ? 0 : getIperfInternal().hashCode());
        result = prime * result + ((getIperfExternal() == null) ? 0 : getIperfExternal().hashCode());
        result = prime * result + ((getNetperfTcpRrInternal() == null) ? 0 : getNetperfTcpRrInternal().hashCode());
        result = prime * result + ((getNetperfTcpCrrInternal() == null) ? 0 : getNetperfTcpCrrInternal().hashCode());
        result = prime * result + ((getNetperfTcpStreamInternal() == null) ? 0 : getNetperfTcpStreamInternal().hashCode());
        result = prime * result + ((getNetperfUdpRrInternal() == null) ? 0 : getNetperfUdpRrInternal().hashCode());
        result = prime * result + ((getFioSequentialWriteBandwidth() == null) ? 0 : getFioSequentialWriteBandwidth().hashCode());
        result = prime * result + ((getFioSequentialReadBandwidth() == null) ? 0 : getFioSequentialReadBandwidth().hashCode());
        result = prime * result + ((getFioRandomWriteBandwidth() == null) ? 0 : getFioRandomWriteBandwidth().hashCode());
        result = prime * result + ((getFioRandomReadBandwidth() == null) ? 0 : getFioRandomReadBandwidth().hashCode());
        result = prime * result + ((getFioSequentialWriteLatency() == null) ? 0 : getFioSequentialWriteLatency().hashCode());
        result = prime * result + ((getFioSequentialReadLatency() == null) ? 0 : getFioSequentialReadLatency().hashCode());
        result = prime * result + ((getFioRandomWriteLatency() == null) ? 0 : getFioRandomWriteLatency().hashCode());
        result = prime * result + ((getFioRandomReadLatency() == null) ? 0 : getFioRandomReadLatency().hashCode());
        result = prime * result + ((getFioSequentialWriteIops() == null) ? 0 : getFioSequentialWriteIops().hashCode());
        result = prime * result + ((getFioSequentialReadIops() == null) ? 0 : getFioSequentialReadIops().hashCode());
        result = prime * result + ((getFioRandomWriteIops() == null) ? 0 : getFioRandomWriteIops().hashCode());
        result = prime * result + ((getFioRandomReadIops() == null) ? 0 : getFioRandomReadIops().hashCode());
        result = prime * result + ((getUnixbenchIndex() == null) ? 0 : getUnixbenchIndex().hashCode());
        result = prime * result + ((getSysbenchOltp() == null) ? 0 : getSysbenchOltp().hashCode());
        result = prime * result + ((getYcsbThroughputA() == null) ? 0 : getYcsbThroughputA().hashCode());
        result = prime * result + ((getYcsbThroughputB() == null) ? 0 : getYcsbThroughputB().hashCode());
        return result;
    }
}
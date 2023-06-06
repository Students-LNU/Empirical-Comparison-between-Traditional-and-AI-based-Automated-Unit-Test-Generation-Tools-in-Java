package org.apache.commons.math3.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.Test;
import org.mockito.Mockito;

public class MathArraysDiffblueTest {
  /**
   * Method under test: {@link MathArrays#scale(double, double[])}
   */
  @Test
  public void testScale() {
    // Arrange and Act
    double[] actualScaleResult = MathArrays.scale(10.0d, new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualScaleResult.length);
    assertEquals(100.0d, actualScaleResult[0], 0.0);
    assertEquals(10.0d, actualScaleResult[1], 0.0);
    assertEquals(100.0d, actualScaleResult[2], 0.0);
    assertEquals(10.0d, actualScaleResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#scaleInPlace(double, double[])}
   */
  @Test
  public void testScaleInPlace() {
    // Arrange
    double[] arr = new double[]{10.0d, 1.0d, 10.0d, 1.0d};

    // Act
    MathArrays.scaleInPlace(10.0d, arr);

    // Assert
    assertEquals(100.0d, arr[0], 0.0);
    assertEquals(10.0d, arr[1], 0.0);
    assertEquals(100.0d, arr[2], 0.0);
    assertEquals(10.0d, arr[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#ebeAdd(double[], double[])}
   */
  @Test
  public void testEbeAdd() throws DimensionMismatchException {
    // Arrange and Act
    double[] actualEbeAddResult = MathArrays.ebeAdd(new double[]{10.0d, 1.0d, 10.0d, 1.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualEbeAddResult.length);
    assertEquals(20.0d, actualEbeAddResult[0], 0.0);
    assertEquals(2.0d, actualEbeAddResult[1], 0.0);
    assertEquals(20.0d, actualEbeAddResult[2], 0.0);
    assertEquals(2.0d, actualEbeAddResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#ebeAdd(double[], double[])}
   */
  @Test
  public void testEbeAdd2() throws DimensionMismatchException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.ebeAdd(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#ebeSubtract(double[], double[])}
   */
  @Test
  public void testEbeSubtract() throws DimensionMismatchException {
    // Arrange and Act
    double[] actualEbeSubtractResult = MathArrays.ebeSubtract(new double[]{10.0d, 1.0d, 10.0d, 1.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualEbeSubtractResult.length);
    assertEquals(0.0d, actualEbeSubtractResult[0], 0.0);
    assertEquals(0.0d, actualEbeSubtractResult[1], 0.0);
    assertEquals(0.0d, actualEbeSubtractResult[2], 0.0);
    assertEquals(0.0d, actualEbeSubtractResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#ebeSubtract(double[], double[])}
   */
  @Test
  public void testEbeSubtract2() throws DimensionMismatchException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.ebeSubtract(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#ebeMultiply(double[], double[])}
   */
  @Test
  public void testEbeMultiply() throws DimensionMismatchException {
    // Arrange and Act
    double[] actualEbeMultiplyResult = MathArrays.ebeMultiply(new double[]{10.0d, 1.0d, 10.0d, 1.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualEbeMultiplyResult.length);
    assertEquals(100.0d, actualEbeMultiplyResult[0], 0.0);
    assertEquals(1.0d, actualEbeMultiplyResult[1], 0.0);
    assertEquals(100.0d, actualEbeMultiplyResult[2], 0.0);
    assertEquals(1.0d, actualEbeMultiplyResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#ebeMultiply(double[], double[])}
   */
  @Test
  public void testEbeMultiply2() throws DimensionMismatchException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.ebeMultiply(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#ebeDivide(double[], double[])}
   */
  @Test
  public void testEbeDivide() throws DimensionMismatchException {
    // Arrange and Act
    double[] actualEbeDivideResult = MathArrays.ebeDivide(new double[]{10.0d, 1.0d, 10.0d, 1.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualEbeDivideResult.length);
    assertEquals(1.0d, actualEbeDivideResult[0], 0.0);
    assertEquals(1.0d, actualEbeDivideResult[1], 0.0);
    assertEquals(1.0d, actualEbeDivideResult[2], 0.0);
    assertEquals(1.0d, actualEbeDivideResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#ebeDivide(double[], double[])}
   */
  @Test
  public void testEbeDivide2() throws DimensionMismatchException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.ebeDivide(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#distance1(double[], double[])}
   */
  @Test
  public void testDistance1() {
    // Arrange, Act and Assert
    assertEquals(0.0d,
        MathArrays.distance1(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(0, MathArrays.distance1(new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0}));
  }

  /**
   * Method under test: {@link MathArrays#distance(double[], double[])}
   */
  @Test
  public void testDistance() {
    // Arrange, Act and Assert
    assertEquals(0.0d,
        MathArrays.distance(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(0.0d, MathArrays.distance(new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0}), 0.0);
  }

  /**
   * Method under test: {@link MathArrays#distanceInf(double[], double[])}
   */
  @Test
  public void testDistanceInf() {
    // Arrange, Act and Assert
    assertEquals(0.0d,
        MathArrays.distanceInf(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(10.0d,
        MathArrays.distanceInf(new double[]{0.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(Double.NaN,
        MathArrays.distanceInf(new double[]{Double.NaN, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}),
        0.0);
    assertEquals(0, MathArrays.distanceInf(new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0}));
    assertEquals(3, MathArrays.distanceInf(new int[]{4, 0, 1, 0}, new int[]{1, 0, 1, 0}));
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(double[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic() {
    // Arrange, Act and Assert
    assertFalse(
        MathArrays.isMonotonic(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, true));
    assertFalse(
        MathArrays.isMonotonic(new double[]{0.5d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, true));
    assertFalse(
        MathArrays.isMonotonic(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, true));
    assertFalse(
        MathArrays.isMonotonic(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, false));
    assertTrue(
        MathArrays.isMonotonic(new double[]{0.5d, 1.0d, Double.NaN, 1.0d}, MathArrays.OrderDirection.INCREASING, true));
    assertFalse(
        MathArrays.isMonotonic(new double[]{0.5d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, false));
    assertFalse(
        MathArrays.isMonotonic(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, false));
    assertTrue(
        MathArrays.isMonotonic(new Comparable[]{mock(Comparable.class)}, MathArrays.OrderDirection.INCREASING, true));
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic2() {
    // Arrange
    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenReturn(1);

    // Act and Assert
    assertFalse(MathArrays.isMonotonic(new Comparable[]{comparable, mock(Comparable.class)},
        MathArrays.OrderDirection.INCREASING, true));
    verify(comparable).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic3() {
    // Arrange
    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenReturn(-1);

    // Act and Assert
    assertTrue(MathArrays.isMonotonic(new Comparable[]{comparable, mock(Comparable.class)},
        MathArrays.OrderDirection.INCREASING, true));
    verify(comparable).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic4() {
    // Arrange
    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenThrow(new DimensionMismatchException(1, 1));

    // Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.isMonotonic(new Comparable[]{comparable, mock(Comparable.class), mock(Comparable.class)},
            MathArrays.OrderDirection.INCREASING, true));
    verify(comparable).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic5() {
    // Arrange
    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenThrow(new DimensionMismatchException(1, 1));
    Comparable<Comparable> comparable2 = mock(Comparable.class);
    when(comparable2.compareTo(Mockito.<Comparable<Object>>any())).thenReturn(1);

    // Act and Assert
    assertFalse(MathArrays.isMonotonic(new Comparable[]{comparable, comparable2, mock(Comparable.class)},
        MathArrays.OrderDirection.DECREASING, true));
    verify(comparable2).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic6() {
    // Arrange
    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenThrow(new DimensionMismatchException(1, 1));
    Comparable<Comparable> comparable2 = mock(Comparable.class);
    when(comparable2.compareTo(Mockito.<Comparable<Object>>any())).thenReturn(-1);
    Comparable<Comparable> comparable3 = mock(Comparable.class);
    when(comparable3.compareTo(Mockito.<Comparable<Object>>any())).thenReturn(1);

    // Act and Assert
    assertFalse(MathArrays.isMonotonic(new Comparable[]{comparable, comparable2, comparable3},
        MathArrays.OrderDirection.DECREASING, true));
    verify(comparable2).compareTo(Mockito.<Comparable<Object>>any());
    verify(comparable3).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#isMonotonic(Comparable[], MathArrays.OrderDirection, boolean)}
   */
  @Test
  public void testIsMonotonic7() {
    // Arrange
    new DimensionMismatchException(1, 1);

    Comparable<Comparable> comparable = mock(Comparable.class);
    when(comparable.compareTo(Mockito.<Comparable<Object>>any())).thenThrow(new DimensionMismatchException(1, 1));

    // Act and Assert
    assertThrows(DimensionMismatchException.class, () -> MathArrays
        .isMonotonic(new Comparable[]{mock(Comparable.class), comparable}, MathArrays.OrderDirection.DECREASING, true));
    verify(comparable).compareTo(Mockito.<Comparable<Object>>any());
  }

  /**
   * Method under test: {@link MathArrays#checkOrder(double[])}
   */
  @Test
  public void testCheckOrder() throws NonMonotonicSequenceException {
    // Arrange, Act and Assert
    assertThrows(NonMonotonicSequenceException.class,
        () -> MathArrays.checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
    assertThrows(NonMonotonicSequenceException.class,
        () -> MathArrays.checkOrder(new double[]{0.5d, 1.0d, 10.0d, 1.0d}));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, true));
    assertThrows(NonMonotonicSequenceException.class,
        () -> MathArrays.checkOrder(new double[]{0.5d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, false));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays.checkOrder(new double[]{0.5d, 1.0d, 10.0d, 1.0d},
        MathArrays.OrderDirection.INCREASING, false));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, false));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, true, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays.checkOrder(new double[]{0.5d, 1.0d, 10.0d, 1.0d},
        MathArrays.OrderDirection.INCREASING, true, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, true, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING, false, true));
    assertFalse(MathArrays.checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.INCREASING,
        true, false));
    assertTrue(MathArrays.checkOrder(new double[]{0.5d, 1.0d, Double.NaN, 1.0d}, MathArrays.OrderDirection.INCREASING,
        true, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays.checkOrder(new double[]{0.5d, 1.0d, 10.0d, 1.0d},
        MathArrays.OrderDirection.INCREASING, false, true));
    assertThrows(NonMonotonicSequenceException.class, () -> MathArrays
        .checkOrder(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, MathArrays.OrderDirection.DECREASING, false, true));
  }

  /**
   * Method under test: {@link MathArrays#checkRectangular(long[][])}
   */
  @Test
  public void testCheckRectangular() throws DimensionMismatchException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.checkRectangular(new long[][]{new long[]{}, new long[]{1L, 0L, 1L, 0L}}));
  }

  /**
   * Method under test: {@link MathArrays#checkPositive(double[])}
   */
  @Test
  public void testCheckPositive() throws NotStrictlyPositiveException {
    // Arrange, Act and Assert
    assertThrows(NotStrictlyPositiveException.class,
        () -> MathArrays.checkPositive(new double[]{0.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
  * Method under test: {@link MathArrays#checkNonNegative(long[])}
  */
  @Test
  public void testCheckNonNegative() throws NotPositiveException {
    // Arrange, Act and Assert
    assertThrows(NotPositiveException.class, () -> MathArrays.checkNonNegative(new long[]{1L, -1L, 1L, -1L}));
    assertThrows(NotPositiveException.class,
        () -> MathArrays.checkNonNegative(new long[][]{new long[]{1L, -1L, 1L, -1L}}));
  }

  /**
   * Method under test: {@link MathArrays#safeNorm(double[])}
   */
  @Test
  public void testSafeNorm() {
    // Arrange, Act and Assert
    assertEquals(14.212670403551895d, MathArrays.safeNorm(new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(1.304E19d, MathArrays.safeNorm(new double[]{1.304E19d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(10.099504938362077d, MathArrays.safeNorm(new double[]{0.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(Double.NaN, MathArrays.safeNorm(new double[]{Double.NaN, 1.0d, 10.0d, 1.0d}), 0.0);
    assertEquals(0.0d, MathArrays.safeNorm(new double[]{}), 0.0);
    assertEquals(2.608E19d,
        MathArrays.safeNorm(
            new double[]{3.834E-20d, 1.304E19d, 3.834E-20d, 1.304E19d, 3.834E-20d, 1.304E19d, 3.834E-20d, 1.304E19d}),
        0.0);
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], MathArrays.OrderDirection, double[][])}
   */
  @Test
  public void testSortInPlace() throws DimensionMismatchException, NullArgumentException {
    // Arrange
    double[] x = new double[]{2.0d, 10.0d, 2.0d, 10.0d};

    // Act
    MathArrays.sortInPlace(x, MathArrays.OrderDirection.INCREASING, new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(2.0d, x[0], 0.0);
    assertEquals(2.0d, x[1], 0.0);
    assertEquals(10.0d, x[2], 0.0);
    assertEquals(10.0d, x[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], MathArrays.OrderDirection, double[][])}
   */
  @Test
  public void testSortInPlace2() throws DimensionMismatchException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(NullArgumentException.class, () -> MathArrays.sortInPlace(null, MathArrays.OrderDirection.INCREASING,
        new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], MathArrays.OrderDirection, double[][])}
   */
  @Test
  public void testSortInPlace3() throws DimensionMismatchException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class, () -> MathArrays.sortInPlace(new double[]{},
        MathArrays.OrderDirection.INCREASING, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], double[][])}
   */
  @Test
  public void testSortInPlace4() throws DimensionMismatchException, NullArgumentException {
    // Arrange
    double[] x = new double[]{2.0d, 10.0d, 2.0d, 10.0d};

    // Act
    MathArrays.sortInPlace(x, new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(2.0d, x[0], 0.0);
    assertEquals(2.0d, x[1], 0.0);
    assertEquals(10.0d, x[2], 0.0);
    assertEquals(10.0d, x[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], double[][])}
   */
  @Test
  public void testSortInPlace5() throws DimensionMismatchException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(NullArgumentException.class,
        () -> MathArrays.sortInPlace(null, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#sortInPlace(double[], double[][])}
   */
  @Test
  public void testSortInPlace6() throws DimensionMismatchException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.sortInPlace(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#copyOf(double[])}
   */
  @Test
  public void testCopyOf() {
    // Arrange and Act
    double[] actualCopyOfResult = MathArrays.copyOf(new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(4, actualCopyOfResult.length);
    assertEquals(10.0d, actualCopyOfResult[0], 0.0);
    assertEquals(1.0d, actualCopyOfResult[1], 0.0);
    assertEquals(10.0d, actualCopyOfResult[2], 0.0);
    assertEquals(1.0d, actualCopyOfResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(double[], int)}
   */
  @Test
  public void testCopyOf2() {
    // Arrange and Act
    double[] actualCopyOfResult = MathArrays.copyOf(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 3);

    // Assert
    assertEquals(3, actualCopyOfResult.length);
    assertEquals(10.0d, actualCopyOfResult[0], 0.0);
    assertEquals(1.0d, actualCopyOfResult[1], 0.0);
    assertEquals(10.0d, actualCopyOfResult[2], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(double[], int)}
   */
  @Test
  public void testCopyOf3() {
    // Arrange and Act
    double[] actualCopyOfResult = MathArrays.copyOf(new double[]{}, 3);

    // Assert
    assertEquals(3, actualCopyOfResult.length);
    assertEquals(0.0d, actualCopyOfResult[0], 0.0);
    assertEquals(0.0d, actualCopyOfResult[1], 0.0);
    assertEquals(0.0d, actualCopyOfResult[2], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(double[], int)}
   */
  @Test
  public void testCopyOf4() {
    // Arrange, Act and Assert
    assertThrows(NegativeArraySizeException.class, () -> MathArrays.copyOf(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, -1));
  }

  /**
   * Method under test: {@link MathArrays#copyOf(int[])}
   */
  @Test
  public void testCopyOf5() {
    // Arrange and Act
    int[] actualCopyOfResult = MathArrays.copyOf(new int[]{1, 0, 1, 0});

    // Assert
    assertEquals(4, actualCopyOfResult.length);
    assertEquals(1, actualCopyOfResult[0]);
    assertEquals(0, actualCopyOfResult[1]);
    assertEquals(1, actualCopyOfResult[2]);
    assertEquals(0, actualCopyOfResult[3]);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(int[], int)}
   */
  @Test
  public void testCopyOf6() {
    // Arrange and Act
    int[] actualCopyOfResult = MathArrays.copyOf(new int[]{1, 0, 1, 0}, 3);

    // Assert
    assertEquals(3, actualCopyOfResult.length);
    assertEquals(1, actualCopyOfResult[0]);
    assertEquals(0, actualCopyOfResult[1]);
    assertEquals(1, actualCopyOfResult[2]);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(int[], int)}
   */
  @Test
  public void testCopyOf7() {
    // Arrange and Act
    int[] actualCopyOfResult = MathArrays.copyOf(new int[]{}, 3);

    // Assert
    assertEquals(3, actualCopyOfResult.length);
    assertEquals(0, actualCopyOfResult[0]);
    assertEquals(0, actualCopyOfResult[1]);
    assertEquals(0, actualCopyOfResult[2]);
  }

  /**
   * Method under test: {@link MathArrays#copyOf(int[], int)}
   */
  @Test
  public void testCopyOf8() {
    // Arrange, Act and Assert
    assertThrows(NegativeArraySizeException.class, () -> MathArrays.copyOf(new int[]{1, 0, 1, 0}, -1));
  }

  /**
   * Method under test: {@link MathArrays#linearCombination(double, double, double, double)}
   */
  @Test
  public void testLinearCombination() {
    // Arrange, Act and Assert
    assertEquals(200.0d, MathArrays.linearCombination(10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(1.34217739E9d, MathArrays.linearCombination(1.34217729E8d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(110.0d, MathArrays.linearCombination(1.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(105.0d, MathArrays.linearCombination(0.5d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(Double.NaN, MathArrays.linearCombination(Double.NaN, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(300.0d, MathArrays.linearCombination(10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(1.34217749E9d, MathArrays.linearCombination(1.34217729E8d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(210.0d, MathArrays.linearCombination(1.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(205.0d, MathArrays.linearCombination(0.5d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(Double.NaN, MathArrays.linearCombination(Double.NaN, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(400.0d, MathArrays.linearCombination(10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(1.34217759E9d,
        MathArrays.linearCombination(1.34217729E8d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(310.0d, MathArrays.linearCombination(1.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(305.0d, MathArrays.linearCombination(0.5d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d), 0.0);
    assertEquals(Double.NaN, MathArrays.linearCombination(Double.NaN, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d),
        0.0);
    assertEquals(202.0d,
        MathArrays.linearCombination(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}),
        0.0);
    assertEquals(Double.NaN, MathArrays.linearCombination(new double[]{Double.NaN, 1.0d, 10.0d, 1.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d}), 0.0);
    assertThrows(DimensionMismatchException.class,
        () -> MathArrays.linearCombination(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#equals(double[], double[])}
   */
  @Test
  public void testEquals() {
    // Arrange, Act and Assert
    assertFalse(MathArrays.equals(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertTrue(MathArrays.equals(new double[]{10.0d, 0.5d, 10.0d, 0.5d}, new double[]{10.0d, 0.5d, 10.0d, 0.5d}));
    assertFalse(MathArrays.equals(new double[]{-0.5d, 10.0d, 2.0d, 10.0d}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equals(null, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equals(new double[]{}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equals(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, new double[]{-0.5d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equals(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, null));
    assertTrue(MathArrays.equals((double[]) null, null));
    assertFalse(
        MathArrays.equals(new double[]{Double.NaN, 10.0d, 2.0d, 10.0d}, new double[]{Double.NaN, 10.0d, 3.0d, 10.0d}));
    assertTrue(MathArrays.equals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(new float[]{0.5f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(new float[]{-0.5f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(null, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(new float[]{}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{-0.5f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, null));
    assertTrue(MathArrays.equals((float[]) null, null));
    assertFalse(
        MathArrays.equals(new float[]{Float.NaN, 0.5f, 10.0f, 0.5f}, new float[]{Float.NaN, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Method under test: {@link MathArrays#equalsIncludingNaN(double[], double[])}
   */
  @Test
  public void testEqualsIncludingNaN() {
    // Arrange, Act and Assert
    assertFalse(
        MathArrays.equalsIncludingNaN(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertTrue(
        MathArrays.equalsIncludingNaN(new double[]{10.0d, 0.5d, 10.0d, 0.5d}, new double[]{10.0d, 0.5d, 10.0d, 0.5d}));
    assertFalse(
        MathArrays.equalsIncludingNaN(new double[]{-0.5d, 10.0d, 2.0d, 10.0d}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equalsIncludingNaN(new double[]{Double.NaN, 10.0d, 2.0d, 10.0d},
        new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equalsIncludingNaN(null, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equalsIncludingNaN(new double[]{}, new double[]{3.0d, 10.0d, 3.0d, 10.0d}));
    assertFalse(
        MathArrays.equalsIncludingNaN(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, new double[]{-0.5d, 10.0d, 3.0d, 10.0d}));
    assertFalse(MathArrays.equalsIncludingNaN(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, null));
    assertFalse(MathArrays.equalsIncludingNaN(new double[]{Double.NaN, 10.0d, 2.0d, 10.0d},
        new double[]{Double.NaN, 10.0d, 3.0d, 10.0d}));
    assertTrue(MathArrays.equalsIncludingNaN((double[]) null, null));
    assertTrue(
        MathArrays.equalsIncludingNaN(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(
        MathArrays.equalsIncludingNaN(new float[]{0.5f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(
        MathArrays.equalsIncludingNaN(new float[]{-0.5f, 0.5f, 10.0f, 0.5f}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equalsIncludingNaN(new float[]{Float.NaN, 0.5f, 10.0f, 0.5f},
        new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equalsIncludingNaN(null, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equalsIncludingNaN(new float[]{}, new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertFalse(
        MathArrays.equalsIncludingNaN(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, new float[]{-0.5f, 0.5f, 10.0f, 0.5f}));
    assertFalse(MathArrays.equalsIncludingNaN(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, null));
    assertTrue(MathArrays.equalsIncludingNaN(new float[]{Float.NaN, 0.5f, 10.0f, 0.5f},
        new float[]{Float.NaN, 0.5f, 10.0f, 0.5f}));
    assertTrue(MathArrays.equalsIncludingNaN((float[]) null, null));
  }

  /**
   * Method under test: {@link MathArrays#normalizeArray(double[], double)}
   */
  @Test
  public void testNormalizeArray() throws MathArithmeticException, MathIllegalArgumentException {
    // Arrange and Act
    double[] actualNormalizeArrayResult = MathArrays.normalizeArray(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, 10.0d);

    // Assert
    assertEquals(4, actualNormalizeArrayResult.length);
    assertEquals(4.545454545454546d, actualNormalizeArrayResult[0], 0.0);
    assertEquals(0.45454545454545453d, actualNormalizeArrayResult[1], 0.0);
    assertEquals(4.545454545454546d, actualNormalizeArrayResult[2], 0.0);
    assertEquals(0.45454545454545453d, actualNormalizeArrayResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#normalizeArray(double[], double)}
   */
  @Test
  public void testNormalizeArray2() throws MathArithmeticException, MathIllegalArgumentException {
    // Arrange and Act
    double[] actualNormalizeArrayResult = MathArrays.normalizeArray(new double[]{Double.NaN, 1.0d, 10.0d, 1.0d}, 10.0d);

    // Assert
    assertEquals(4, actualNormalizeArrayResult.length);
    assertEquals(Double.NaN, actualNormalizeArrayResult[0], 0.0);
    assertEquals(0.8333333333333334d, actualNormalizeArrayResult[1], 0.0);
    assertEquals(8.333333333333334d, actualNormalizeArrayResult[2], 0.0);
    assertEquals(0.8333333333333334d, actualNormalizeArrayResult[3], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#normalizeArray(double[], double)}
   */
  @Test
  public void testNormalizeArray3() throws MathArithmeticException, MathIllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(MathArithmeticException.class, () -> MathArrays.normalizeArray(new double[]{}, 10.0d));
  }

  /**
   * Method under test: {@link MathArrays#normalizeArray(double[], double)}
   */
  @Test
  public void testNormalizeArray4() throws MathArithmeticException, MathIllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(MathIllegalArgumentException.class,
        () -> MathArrays.normalizeArray(new double[]{10.0d, 1.0d, 10.0d, 1.0d}, Double.NaN));
  }

  /**
   * Method under test: {@link MathArrays#convolve(double[], double[])}
   */
  @Test
  public void testConvolve() throws NoDataException, NullArgumentException {
    // Arrange and Act
    double[] actualConvolveResult = MathArrays.convolve(new double[]{2.0d, 10.0d, 2.0d, 10.0d},
        new double[]{10.0d, 1.0d, 10.0d, 1.0d});

    // Assert
    assertEquals(7, actualConvolveResult.length);
    assertEquals(20.0d, actualConvolveResult[0], 0.0);
    assertEquals(102.0d, actualConvolveResult[1], 0.0);
    assertEquals(50.0d, actualConvolveResult[2], 0.0);
    assertEquals(204.0d, actualConvolveResult[3], 0.0);
    assertEquals(40.0d, actualConvolveResult[4], 0.0);
    assertEquals(102.0d, actualConvolveResult[5], 0.0);
    assertEquals(10.0d, actualConvolveResult[6], 0.0);
  }

  /**
   * Method under test: {@link MathArrays#convolve(double[], double[])}
   */
  @Test
  public void testConvolve2() throws NoDataException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(NoDataException.class,
        () -> MathArrays.convolve(new double[]{}, new double[]{10.0d, 1.0d, 10.0d, 1.0d}));
  }

  /**
   * Method under test: {@link MathArrays#convolve(double[], double[])}
   */
  @Test
  public void testConvolve3() throws NoDataException, NullArgumentException {
    // Arrange, Act and Assert
    assertThrows(NoDataException.class,
        () -> MathArrays.convolve(new double[]{2.0d, 10.0d, 2.0d, 10.0d}, new double[]{}));
  }
}

